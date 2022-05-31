package com.elslode.chibbistestapp.domain

import com.elslode.chibbistestapp.domain.review.ReviewsEntity

interface ReviewRepository {

    suspend fun getReviewList(): List<ReviewsEntity>
    suspend fun loadReviewList()
}