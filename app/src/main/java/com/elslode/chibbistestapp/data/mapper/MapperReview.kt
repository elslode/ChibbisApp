package com.elslode.chibbistestapp.data.mapper

import com.elslode.chibbistestapp.data.database.reviewDb.ReviewDbModel
import com.elslode.chibbistestapp.data.network.reviewsDto.ReviewsDto
import com.elslode.chibbistestapp.domain.review.ReviewsEntity
import javax.inject.Inject

class MapperReview @Inject constructor() {

    fun mapReviewDtoToDbModel(reviewList: List<ReviewsDto>) =
        reviewList.map {
            ReviewDbModel(
                IsPositive = it.IsPositive,
                Message = it.Message,
                DateAdded = it.DateAdded,
                UserFIO = it.UserFIO,
                RestaurantName = it.RestaurantName
            )
        }

    fun mapReviewDbModelToEntity(reviewList: List<ReviewDbModel>) =
        reviewList.map {
            ReviewsEntity(
                IsPositive = it.IsPositive,
                Message = it.Message,
                DateAdded = it.DateAdded,
                UserFIO = it.UserFIO,
                RestaurantName = it.RestaurantName
            )
        }


}