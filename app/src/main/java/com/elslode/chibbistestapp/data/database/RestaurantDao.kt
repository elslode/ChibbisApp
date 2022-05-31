package com.elslode.chibbistestapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elslode.chibbistestapp.data.database.restaurantDb.RestaurantDbModel

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant_table")
    fun getTicketList(): List<RestaurantDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTicketsList(trips: List<RestaurantDbModel>)

}