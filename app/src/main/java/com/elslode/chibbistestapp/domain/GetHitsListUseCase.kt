package com.elslode.chibbistestapp.domain

import javax.inject.Inject

class GetHitsListUseCase @Inject constructor(
    private val repository: HitsRepository
){
    suspend operator fun invoke() = repository.getHitsList()
}