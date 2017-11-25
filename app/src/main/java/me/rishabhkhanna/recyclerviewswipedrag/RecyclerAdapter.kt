package me.rishabhkhanna.recyclerviewswipedrag

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by rishabhkhanna on 14/11/17.
 */
class RecyclerAdapter(internal var arrayList: ArrayList<String>, internal var context: Context) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
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

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvName: TextView
        init {
            tvName = itemView.findViewById(R.id.tvName)
        }
    }

}