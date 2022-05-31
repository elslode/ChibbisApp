package com.elslode.chibbistestapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elslode.chibbistestapp.data.database.reviewDb.ReviewDbModel

@Dao
interface ReviewDao {
    @Query("SELECT * FROM review_table")
    fun getReviewList(): List<ReviewDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveReviewList(trips: List<ReviewDbModel>)
}