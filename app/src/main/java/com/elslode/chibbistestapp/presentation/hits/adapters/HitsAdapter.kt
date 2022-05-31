package com.elslode.chibbistestapp.presentation.hits.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.elslode.chibbistestapp.R
import com.elslode.chibbistestapp.databinding.ItemHitBinding
import com.elslode.chibbistestapp.domain.hits.HitsEntity
import com.squareup.picasso.Picasso
import javax.inject.Inject

class HitsAdapter @Inject constructor(
    val application: Application
) : ListAdapter<HitsEntity, HitsViewHolder>(HitsDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  HitsViewHolder {
        val binding = ItemHitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HitsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HitsViewHolder, position: Int) {
        val hit = getItem(position)
        val binding = holder.binding
        with(holder.binding) {
            with(hit) {
                binding.nameOfProduct.text = this.ProductName
                Picasso.get().load(this.ProductImage).placeholder(R.drawable.food_ic).into(binding.imageOfProduct)
                binding.priceOfProduct.text = application.getString(R.string.price).format(this.ProductPrice)
                binding.productDescription.text = this.ProductDescription
            }
        }
    }
}
