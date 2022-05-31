package com.elslode.chibbistestapp.domain.review

data class ReviewsEntity(
    val id: Int = 0,
    val IsPositive: Boolean? = null,
    val Message: String? = null,
    val DateAdded: String? = null,
    val UserFIO: String? = null,
    val RestaurantName: String? = null
)