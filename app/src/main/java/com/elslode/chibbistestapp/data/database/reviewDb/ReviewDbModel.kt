package com.elslode.chibbistestapp.data.database.reviewDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review_table")
data class ReviewDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val IsPositive: Boolean? = null,
    val Message: String? = null,
    val DateAdded: String? = null,
    val UserFIO: String? = null,
    val RestaurantName: String? = null
)
