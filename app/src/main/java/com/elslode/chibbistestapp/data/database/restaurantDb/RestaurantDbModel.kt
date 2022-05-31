package com.elslode.chibbistestapp.data.database.restaurantDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class RestaurantDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val Name: String? = null,
    val Logo: String? = null,
    val MinCost: Int? = null,
    val DeliveryCost: Int? = null,
    val DeliveryTime: Int? = null,
    val PositiveReviews: Int? = null,
    val ReviewsCount: Int? = null,
    val Specializations: List<SpecializationDbModel>? = null
)
