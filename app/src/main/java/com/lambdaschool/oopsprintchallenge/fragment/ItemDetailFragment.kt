package com.lambdaschool.oopsprintchallenge.fragment

import android.content.Context
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
import java.lang.RuntimeException

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
    private var listener: OnItemDetailFragmentInteractionListener? = null

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemDetailFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnItemDetailFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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

        val item = arguments?.getSerializable(ARG_ITEM_ID) as AgeOfEmpiresApiObject

        item_detail.text = item.name + "\n\n\n" + item.description()
        item_detail.setOnClickListener {
            listener?.onItemDetailFragmentInteractionListener(item)
        }
    }

    interface OnItemDetailFragmentInteractionListener {
        fun onItemDetailFragmentInteractionListener(item: AgeOfEmpiresApiObject)
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
