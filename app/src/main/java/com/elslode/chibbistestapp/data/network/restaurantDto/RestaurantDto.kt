package com.elslode.chibbistestapp.data.network.restaurantDto

data class RestaurantDto(
    val id: Int = 0,
    val Name: String? = null,
    val Logo: String? = null,
    val MinCost: Int? = null,
    val DeliveryCost: Int? = null,
    val DeliveryTime: Int? = null,
    val PositiveReviews: Int? = null,
    val ReviewsCount: Int? = null,
    val Specializations: List<SpecializationDto>? = null
)
