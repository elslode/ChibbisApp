package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class LoadRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    suspend operator fun invoke() = repository.loadRestaurantList()
}