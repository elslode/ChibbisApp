package com.elslode.chibbistestapp.data.network

import com.elslode.chibbistestapp.data.network.hitsDto.HitsDto
import com.elslode.chibbistestapp.data.network.restaurantDto.RestaurantDto
import com.elslode.chibbistestapp.data.network.reviewsDto.ReviewsDto
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/restaurants")
    suspend fun getRestaurants(): List<RestaurantDto>

    @GET("api/v1/hits")
    suspend fun getHits(): List<HitsDto>

    @GET("api/v1/reviews")
    suspend fun getReviews(): List<ReviewsDto>
}