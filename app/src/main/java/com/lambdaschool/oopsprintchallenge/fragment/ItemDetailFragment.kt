package com.lambdaschool.oopsprintchallenge.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lambdaschool.oopsprintchallenge.R
import com.lambdaschool.oopsprintchallenge.model.AgeOfEmpiresApiObject
import com.lambdaschool.oopsprintchallenge.model.Civilization
import com.lambdaschool.oopsprintchallenge.model.Structure
import com.lambdaschool.oopsprintchallenge.model.Technology
import com.lambdaschool.oopsprintchallenge.model.Unit
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    //private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                //item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                //activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        /*item?.let {
            rootView.item_detail.text = it.details
        }*/

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var item = arguments?.getSerializable(ARG_ITEM_ID) as AgeOfEmpiresApiObject

        /*if (item.category == "Civilization") {
            item = item as Civilization
        } else if (item.category == "Structure") {
            item = item as Structure
        } else if (item.category == "Technology") {
            item = item as Technology
        } else {
            item = item as Unit
        }*/

        item_detail.text = item.name + "\n\n\n" + item.description()
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
