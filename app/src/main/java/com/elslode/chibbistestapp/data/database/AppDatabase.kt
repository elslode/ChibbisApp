package com.elslode.chibbistestapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elslode.chibbistestapp.data.database.hitsDb.HitsDbModel
import com.elslode.chibbistestapp.data.database.restaurantDb.RestaurantDbModel
import com.elslode.chibbistestapp.data.database.reviewDb.ReviewDbModel

@Database(entities = [RestaurantDbModel::class, HitsDbModel::class, ReviewDbModel::class], version = 2, exportSchema = false)
@TypeConverters(ConverterRestaurants::class)
abstract class AppDatabase: RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun restaurantDao(): RestaurantDao
    abstract fun hitsDao(): HitsDao
    abstract fun reviewDao(): ReviewDao
}