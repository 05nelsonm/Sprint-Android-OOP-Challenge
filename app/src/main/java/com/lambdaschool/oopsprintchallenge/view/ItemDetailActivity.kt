package com.lambdaschool.oopsprintchallenge.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.lambdaschool.oopsprintchallenge.R
import com.lambdaschool.oopsprintchallenge.fragment.ItemDetailFragment
import com.lambdaschool.oopsprintchallenge.model.AgeOfEmpiresApiObject
import com.lambdaschool.oopsprintchallenge.viewmodel.ItemListViewModel
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.activity_item_detail.fab
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_detail.*

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity(), ItemDetailFragment.OnItemDetailFragmentInteractionListener {
    override fun onItemDetailFragmentInteractionListener(item: AgeOfEmpiresApiObject) {
        Toast.makeText(this, "${item.name} was shown", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        val bundle: Bundle? = intent.extras
        val ageOfEmpiresObject = bundle?.getSerializable("blah") as AgeOfEmpiresApiObject

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Added to Favorites!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //ageOfEmpiresObject.category
            //fab.setBackgroundColor(Color.GREEN)
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = ItemDetailFragment()
            val fragmentBundle = Bundle()
            fragmentBundle.putSerializable(
                ItemDetailFragment.ARG_ITEM_ID,
                ageOfEmpiresObject
            )
            fragment.arguments = fragmentBundle

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    /*override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }*/
}
