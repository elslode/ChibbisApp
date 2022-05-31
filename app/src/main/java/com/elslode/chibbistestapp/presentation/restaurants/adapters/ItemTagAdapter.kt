package com.elslode.chibbistestapp.presentation.restaurants.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elslode.chibbistestapp.domain.restaurantEntity.SpecializationEntity

class ItemTagAdapter(val context: Context, val items: List<SpecializationEntity>) :
    RecyclerView.Adapter<ItemTagAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTag(context).apply {
                layoutParams = RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT
                )
            }
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items.getOrNull(position).let { entity ->
            entity?.Name?.let { tag ->
                (holder.itemView as? ItemTag)?.init(tag)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}