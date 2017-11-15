package me.rishabhkhanna.recyclerviewswipedrag

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import me.rishabhkhanna.recyclerswipedrag.ItemTouchHelperAdapter
import java.util.*

/**
 * Created by rishabhkhanna on 14/11/17.
 */
class RecyclerAdapter(internal var arrayList: ArrayList<String>, internal var context: Context) : RecyclerView.Adapter<RecyclerAdapter.Holder>(), ItemTouchHelperAdapter {
    val TAG = "TopicAdapter"
    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Log.d(TAG, "onItemMoved: FROM: " + fromPosition)
        Log.d(TAG, "onItemMoved: TO: " + toPosition)
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(arrayList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(arrayList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onMoved(fromPos: Int, toPos: Int) {
        Log.d(TAG, "onSwipe: FROM: " + fromPos)
        Log.d(TAG, "onSwipe: TO: " + toPos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return Holder(li.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvName.setText(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.tvName) as TextView
    }
}