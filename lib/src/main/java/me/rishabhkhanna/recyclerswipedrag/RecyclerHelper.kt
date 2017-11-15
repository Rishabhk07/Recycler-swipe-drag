package me.rishabhkhanna.recyclerswipedrag

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by rishabhkhanna on 14/11/17.
 */
class RecyclerHelper<T>(var list: ArrayList<T>,var mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : ItemTouchHelper.Callback(), ItemTouchHelperAdapter {

    var onDragListener:onDragListener? = null
    var onSwipeListener:onSwipeListener? = null

    override fun onMoved(fromPos: Int, toPos: Int) {
        list.removeAt(toPos)
        mAdapter.notifyItemRemoved(toPos)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(list, fromPosition, toPosition)
        mAdapter.notifyItemMoved(fromPosition,toPosition)
    }

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        var dragFlags: Int = ItemTouchHelper.UP or ItemTouchHelper.DOWN;
        var swipeFlags: Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        onItemMoved(viewHolder!!.adapterPosition, target!!.adapterPosition)
        onDragListener!!.onDragItemListener(viewHolder!!.adapterPosition, target!!.adapterPosition)
        return true;
    }


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        onMoved(viewHolder!!.oldPosition, viewHolder.adapterPosition)
        onSwipeListener!!.onSwipeItemListener()
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true;
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true;
    }

    fun setOnDragItemListener(onDragListener: onDragListener){
        this.onDragListener = onDragListener
    }

    fun setOnSwipeItemListener(onSwipeListener: onSwipeListener){
        this.onSwipeListener = onSwipeListener
    }

}