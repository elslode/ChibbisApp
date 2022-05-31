package com.elslode.chibbistestapp.data.network.reviewsDto

data class ReviewsDto(
    val id: Int = 0,
    val IsPositive: Boolean? = null,
    val Message: String? = null,
    val DateAdded: String? = null,
    val UserFIO: String? = null,
    val RestaurantName: String? = null
)
