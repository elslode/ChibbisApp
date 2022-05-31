package com.elslode.chibbistestapp.data.repository

import com.elslode.chibbistestapp.data.database.RestaurantDao
import com.elslode.chibbistestapp.data.mapper.MapperRestaurants
import com.elslode.chibbistestapp.data.network.ApiService
import com.elslode.chibbistestapp.domain.RestaurantRepository
import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity
import javax.inject.Inject

class RestaurantsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapperRestaurants: MapperRestaurants,
    private val dao: RestaurantDao
): RestaurantRepository {

    override suspend fun loadRestaurantList() {
        val listRestaurants = apiService.getRestaurants()
         listRestaurants.let {
            mapperRestaurants.mapRestDtoToDbModel(it).let { listRest->
                dao.saveTicketsList(listRest)
            }
        }
    }

    override suspend fun getRestaurantList(): List<RestaurantEntity> {
        val listRest = dao.getTicketList()
        return listRest.map {
            mapperRestaurants.mapRestDbModelToEntity(it)
        }
    }

}