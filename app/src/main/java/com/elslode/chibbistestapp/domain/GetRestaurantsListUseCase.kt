package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class GetRestaurantsListUseCase @Inject constructor(
    private val repository: RestaurantRepository
){
    suspend operator fun invoke() = repository.getRestaurantList()
}