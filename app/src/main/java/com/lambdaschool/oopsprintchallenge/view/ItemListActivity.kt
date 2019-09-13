package com.lambdaschool.oopsprintchallenge.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.lambdaschool.oopsprintchallenge.R

import com.lambdaschool.oopsprintchallenge.dummy.DummyContent
import com.lambdaschool.oopsprintchallenge.fragment.ItemDetailFragment
import com.lambdaschool.oopsprintchallenge.model.AgeOfEmpiresApiObject
import com.lambdaschool.oopsprintchallenge.retrofit.AgeOfEmpireAPI
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*
import kotlinx.android.synthetic.main.item_list.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    var ageOfEmpiresApiObjects = mutableListOf<AgeOfEmpiresApiObject>()

    lateinit var ageOfEmpireAPI: AgeOfEmpireAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        ageOfEmpiresApiObjects = mutableListOf()

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        if (item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        ageOfEmpireAPI = AgeOfEmpireAPI.Factory.create()

        setupRecyclerView(item_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, ageOfEmpiresApiObjects, twoPane)

    }

    class SimpleItemRecyclerViewAdapter(
        private val parentActivity: ItemListActivity,
        private val values: MutableList<AgeOfEmpiresApiObject>,
        private val twoPane: Boolean
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as DummyContent.DummyItem
                if (twoPane) {
                    val fragment = ItemDetailFragment()
                        .apply {
                        arguments = Bundle().apply {
                            putString(ItemDetailFragment.ARG_ITEM_ID, item.id)
                        }
                    }
                    parentActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit()
                } else {
                    val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                        putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            //holder.image.setImageDrawable(item.)
            holder.name.text = item.name
            holder.button.text = buttonTextFavorite(item.isFavorite)
            holder.button.setOnClickListener {
                if (item.isFavorite) {
                    item.isFavorite = false
                    holder.button.text = buttonTextFavorite(item.isFavorite)
                    holder.button.setBackgroundResource(R.color.buttonColor)
                } else {
                    item.isFavorite = true
                    holder.button.text = buttonTextFavorite(item.isFavorite)
                    holder.button.setBackgroundResource(R.color.colorAccent)
                }
            }


            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        fun buttonTextFavorite(boolean: Boolean): String {
            return if (boolean) {
                "Favorite"
            } else {
                "Unfavorite"
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val image: ImageView = view.iv_model_class
            val name: TextView = view.tv_name
            val button: Button = view.btn_favorite
        }
    }
}
