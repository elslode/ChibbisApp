package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class LoadReviewListUseCase @Inject constructor(
    private val repository: ReviewRepository
) {
    suspend operator fun invoke() = repository.loadReviewList()
}