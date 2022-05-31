package com.elslode.chibbistestapp.data.repository

import com.elslode.chibbistestapp.data.database.ReviewDao
import com.elslode.chibbistestapp.data.mapper.MapperReview
import com.elslode.chibbistestapp.data.network.ApiService
import com.elslode.chibbistestapp.domain.ReviewRepository
import com.elslode.chibbistestapp.domain.review.ReviewsEntity
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val dao: ReviewDao,
    private val apiService: ApiService,
    private val mapperReview: MapperReview
): ReviewRepository{

    override suspend fun getReviewList(): List<ReviewsEntity> {
       return dao.getReviewList().let {
           mapperReview.mapReviewDbModelToEntity(it)
       }
    }

    override suspend fun loadReviewList() {
        val listReview = apiService.getReviews()
        listReview.let {
            mapperReview.mapReviewDtoToDbModel(it).let { listReview ->
                dao.saveReviewList(listReview)
            }
        }
    }

}