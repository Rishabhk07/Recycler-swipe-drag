package me.rishabhkhanna.recyclerswipedrag

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

/**
 * Created by rishabhkhanna on 14/11/17.
 */
class RecyclerHelper(var mAdapter : ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        var dragFlags:Int = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT;
        var swipeFlags:Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        mAdapter.onItemMoved(viewHolder!!.adapterPosition, target!!.adapterPosition)
        return true;
    }

    override fun onMoved(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, fromPos: Int, target: RecyclerView.ViewHolder?, toPos: Int, x: Int, y: Int) {
        mAdapter.onItemMoved(fromPos,toPos)
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        mAdapter.onMoved(viewHolder!!.oldPosition,viewHolder.adapterPosition)
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true;
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true;
    }

}