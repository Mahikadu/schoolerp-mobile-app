package com.edu.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.AttendanceData.GenreViewHolder;
import com.edu.AttendanceData.SingleCheckGenre;
import com.edu.DataModel.Divisions;
import com.edu.R;
import com.edu.adapter.SingleCheckArtistViewHolder;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter extends CheckableChildRecyclerViewAdapter<GenreViewHolder, SingleCheckArtistViewHolder> {

    private DivStd.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<SingleCheckGenre> groups) {
        super(groups);
    }

    @Override
    public SingleCheckArtistViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_singlecheck_arist, parent, false);
        return new SingleCheckArtistViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(SingleCheckArtistViewHolder holder, int position,
                                           CheckedExpandableGroup group, int childIndex) {
        final Divisions artist = (Divisions) group.getItems().get(childIndex);
        holder.setArtistName(artist.getName());
        Log.d("TAG", ""+artist.getName());
//        mListener.onListFragmentInteraction(artist.getName());
    }

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_genre, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setGenreTitle(group);
    }

//        private val mValues: List<DummyItem>,
//        private val mListener: OnListFragmentInteractionListener?)
//    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

//    private val mOnClickListener: View.OnClickListener
//
//    init {
//        mOnClickListener = View.OnClickListener { v ->
//            val item = v.tag as DummyItem
//            // Notify the active callbacks interface (the activity, if the fragment is attached to
//            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.fragment_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mValues[position]
//        holder.mIdView.text = item.id
//        holder.mContentView.text = item.content
//
//        with(holder.mView) {
//            tag = item
//            setOnClickListener(mOnClickListener)
//        }
//    }
//
//    override fun getItemCount(): Int = mValues.size
//
//    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val mIdView: TextView = mView.item_number
//        val mContentView: TextView = mView.content
//
//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
//    }
}
