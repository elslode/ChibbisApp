package com.elslode.chibbistestapp.presentation.restaurants.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.elslode.chibbistestapp.R
import com.elslode.chibbistestapp.databinding.ItemRestaurantBinding
import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity
import com.elslode.onetwotrip.presentation.adapter.RestaurantDiffCallback
import com.squareup.picasso.Picasso
import javax.inject.Inject

class RestaurantAdapter @Inject constructor(
    val application: Application
) : ListAdapter<RestaurantEntity, RestaurantViewHolder>(RestaurantDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val trip = getItem(position)
        val binding = holder.binding
        with(holder.binding) {
            with(trip) {
                //TODO: добавь фотку заглушки!
                Picasso.get().load(this.Logo).placeholder(R.drawable.background).into(binding.restaurantImageView)
                binding.restaurantName.text = this.Name
                binding.countOfReview.text = application.getString(R.string.review_score).format(this.ReviewsCount)
                binding.tvPriceMin.text = application.getString(R.string.cost_min).format(this.MinCost)
                binding.deliveryTime.text = application.getString(R.string.minute).format(this.DeliveryTime)
                //TODO: посмотри, как ресайклер теги устроены, нужно исправить
                binding.recyclerTags.layoutManager =
                    LinearLayoutManager(application, LinearLayoutManager.VERTICAL, false)
                binding.recyclerTags.adapter = this.Specializations?.let {
                    ItemTagAdapter(
                        context = application,
                        items = it
                    )
                }
            }
        }
    }
}
