package com.elslode.onetwotrip.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity

object RestaurantDiffCallback: DiffUtil.ItemCallback<RestaurantEntity>()  {

    override fun areItemsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RestaurantEntity, newItem: RestaurantEntity): Boolean {
        return oldItem == newItem
    }
}