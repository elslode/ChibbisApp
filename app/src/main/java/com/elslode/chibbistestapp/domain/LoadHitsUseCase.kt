package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class LoadHitsUseCase @Inject constructor(
    private val repository: HitsRepository
) {
    suspend operator fun invoke() = repository.loadHitsList()
}