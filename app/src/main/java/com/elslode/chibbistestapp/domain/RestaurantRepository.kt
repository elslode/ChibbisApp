package com.elslode.chibbistestapp.domain

import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity

interface RestaurantRepository {

    suspend fun loadRestaurantList()
    suspend fun getRestaurantList(): List<RestaurantEntity>
}