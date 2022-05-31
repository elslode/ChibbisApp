package com.elslode.chibbistestapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elslode.chibbistestapp.data.database.hitsDb.HitsDbModel

@Dao
interface HitsDao {
    @Query("SELECT * FROM hits_table")
    fun getHitsList(): List<HitsDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHitsList(trips: List<HitsDbModel>)
}