package com.elslode.chibbistestapp.data.repository

import com.elslode.chibbistestapp.data.database.HitsDao
import com.elslode.chibbistestapp.data.mapper.MapperHits
import com.elslode.chibbistestapp.data.network.ApiService
import com.elslode.chibbistestapp.domain.HitsRepository
import com.elslode.chibbistestapp.domain.hits.HitsEntity
import javax.inject.Inject

class HitsRepositoryImpl @Inject constructor(
    private val dao: HitsDao,
    private val apiService: ApiService,
    private val mapperHits: MapperHits
): HitsRepository {

    override suspend fun loadHitsList() {
       val listHits = apiService.getHits()
        listHits.let {
            mapperHits.hitsDtoToDbModel(it).let { listHits ->
                dao.saveHitsList(listHits)
            }
        }
    }

    override suspend fun getHitsList(): List<HitsEntity> {
        return dao.getHitsList().let {
            mapperHits.hitsDbModelToEntity(it)
        }
    }

}