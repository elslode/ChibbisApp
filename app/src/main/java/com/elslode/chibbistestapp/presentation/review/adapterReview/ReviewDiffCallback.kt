package com.elslode.chibbistestapp.presentation.review.adapterReview

import androidx.recyclerview.widget.DiffUtil
import com.elslode.chibbistestapp.domain.review.ReviewsEntity

object ReviewDiffCallback: DiffUtil.ItemCallback<ReviewsEntity>()  {

    override fun areItemsTheSame(oldItem: ReviewsEntity, newItem: ReviewsEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ReviewsEntity, newItem: ReviewsEntity): Boolean {
        return oldItem == newItem
    }
}