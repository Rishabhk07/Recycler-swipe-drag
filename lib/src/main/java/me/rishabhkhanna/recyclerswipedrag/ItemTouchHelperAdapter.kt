package me.rishabhkhanna.recyclerswipedrag

/**
 * Created by rishabhkhanna on 14/11/17.
 */
interface ItemTouchHelperAdapter {
    fun onItemMoved(fromPosition: Int, toPosition: Int)
    fun onMoved(fromPos: Int, toPos: Int)
}