package com.elslode.chibbistestapp.data.mapper

import com.elslode.chibbistestapp.data.database.hitsDb.HitsDbModel
import com.elslode.chibbistestapp.data.network.hitsDto.HitsDto
import com.elslode.chibbistestapp.domain.hits.HitsEntity
import javax.inject.Inject

class MapperHits @Inject constructor() {

    fun hitsDtoToDbModel(listHitsDto: List<HitsDto>) =
        listHitsDto.map {
            HitsDbModel(
                id = it.id,
                ProductName = it.ProductName ,
                ProductImage = it.ProductImage,
                ProductPrice = it.ProductPrice,
                ProductDescription = it.ProductDescription,
                RestaurantId = it.RestaurantId,
                RestaurantName = it.RestaurantName,
                RestaurantLogo =it.RestaurantLogo
            )
        }

    fun hitsDbModelToEntity(listDbModel: List<HitsDbModel>) =
        listDbModel.map {
            HitsEntity(
                id = it.id,
                ProductName = it.ProductName ,
                ProductImage = it.ProductImage,
                ProductPrice = it.ProductPrice,
                ProductDescription = it.ProductDescription,
                RestaurantId = it.RestaurantId,
                RestaurantName = it.RestaurantName,
                RestaurantLogo =it.RestaurantLogo
            )
        }
}