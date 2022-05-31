package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class GetReviewListUseCase @Inject constructor(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke() = repository.getReviewList()
}