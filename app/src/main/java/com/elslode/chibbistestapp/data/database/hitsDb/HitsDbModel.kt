package com.elslode.chibbistestapp.data.database.hitsDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hits_table")
data class HitsDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val ProductName: String? = null,
    val ProductImage: String? = null,
    val ProductPrice: Int? = null,
    val ProductDescription: String? = null,
    val RestaurantId: Int? = null,
    val RestaurantName: String? = null,
    val RestaurantLogo: String? = null
)