package com.elslode.chibbistestapp.domain.hits

data class HitsEntity(
     val id: Int = 0,
     val ProductName: String? = null,
     val ProductImage: String? = null,
     val ProductPrice: Int? = null,
     val ProductDescription: String? = null,
     val RestaurantId: Int? = null,
     val RestaurantName: String? = null,
     val RestaurantLogo: String? = null
)
