package com.harman.fca.pagedlistsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SamplePagedListAdapter(val context: Context) :
    PagedListAdapter<Item, SamplePagedListAdapter.ItemViewHolder>(DIF_CALLBACK) {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.image)
        var name: TextView = itemView.findViewById(R.id.name)
        var detail: TextView = itemView.findViewById(R.id.data)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val Item = getItem(position)
        if (Item != null) {
            Glide.with(context).load(Item.owner?.profile_image).into(holder.image)
            holder.name.setText(Item.owner?.display_name)
            holder.detail.setText(Item.owner?.user_type)
        }
    }

    companion object {

        val DIF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.equals(newItem)
            }

            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.answer_id == newItem.answer_id
            }
        }
    }
}