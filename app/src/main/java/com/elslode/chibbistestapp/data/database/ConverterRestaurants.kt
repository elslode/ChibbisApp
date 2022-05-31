package com.elslode.chibbistestapp.data.database

import androidx.room.TypeConverter
import com.elslode.chibbistestapp.data.database.restaurantDb.SpecializationDbModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ConverterRestaurants {

    private var gson = Gson()

    @TypeConverter
    fun stringToSpecializationList(data: String?): List<SpecializationDbModel?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<SpecializationDbModel?>?>() {}.type
        return gson.fromJson<List<SpecializationDbModel?>>(data, listType)
    }

    @TypeConverter
    fun specializationListToString(someObjects: List<SpecializationDbModel?>?): String? {
        return gson.toJson(someObjects)
    }
}