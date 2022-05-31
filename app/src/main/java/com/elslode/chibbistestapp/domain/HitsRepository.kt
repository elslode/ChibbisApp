package com.elslode.chibbistestapp.domain

import com.elslode.chibbistestapp.domain.hits.HitsEntity

interface HitsRepository {

    suspend fun loadHitsList()
    suspend fun getHitsList(): List<HitsEntity>
}