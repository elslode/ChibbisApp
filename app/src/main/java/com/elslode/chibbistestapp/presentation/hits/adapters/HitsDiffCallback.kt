package com.elslode.chibbistestapp.presentation.hits.adapters

import androidx.recyclerview.widget.DiffUtil
import com.elslode.chibbistestapp.domain.hits.HitsEntity

object HitsDiffCallback: DiffUtil.ItemCallback<HitsEntity>()  {

    override fun areItemsTheSame(oldItem: HitsEntity, newItem: HitsEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HitsEntity, newItem: HitsEntity): Boolean {
        return oldItem == newItem
    }
}