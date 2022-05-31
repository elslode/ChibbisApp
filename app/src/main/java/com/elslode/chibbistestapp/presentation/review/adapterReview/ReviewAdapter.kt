package com.elslode.chibbistestapp.presentation.review.adapterReview

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.elslode.chibbistestapp.R
import com.elslode.chibbistestapp.databinding.ItemReviewBinding
import com.elslode.chibbistestapp.domain.review.ReviewsEntity
import com.elslode.chibbistestapp.presentation.review.DataFormatted
import javax.inject.Inject

class ReviewAdapter @Inject constructor(
    val application: Application
) : ListAdapter<ReviewsEntity, ReviewViewHolder>(ReviewDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = getItem(position)
        val binding = holder.binding
        with(holder.binding) {
            with(review) {
                if (this.IsPositive == true) {
                    binding.imEvaluation.setImageResource(R.drawable.ic_like)
                } else {
                    binding.imEvaluation.setImageResource(R.drawable.ic_dislike)
                }
                binding.tvNameOfUser.text = this.UserFIO
                binding.tvMessage.text = this.Message
                binding.tvNameOfRest.text = this.RestaurantName
                binding.tvData.text = DataFormatted.formatData(this.DateAdded)
            }
        }
    }
}

