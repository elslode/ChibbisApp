package com.elslode.chibbistestapp.data.mapper

import com.elslode.chibbistestapp.data.database.restaurantDb.RestaurantDbModel
import com.elslode.chibbistestapp.data.database.restaurantDb.SpecializationDbModel
import com.elslode.chibbistestapp.data.network.restaurantDto.RestaurantDto
import com.elslode.chibbistestapp.data.network.restaurantDto.SpecializationDto
import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity
import com.elslode.chibbistestapp.domain.restaurantEntity.SpecializationEntity
import javax.inject.Inject

class MapperRestaurants @Inject constructor() {

    fun mapRestDtoToDbModel(restaurantDto: List<RestaurantDto>) =
        restaurantDto.map { dto ->
            RestaurantDbModel(
                Name = dto.Name,
                Logo = dto.Logo,
                MinCost = dto.MinCost,
                DeliveryCost = dto.DeliveryCost,
                DeliveryTime = dto.DeliveryTime,
                PositiveReviews = dto.PositiveReviews,
                ReviewsCount = dto.ReviewsCount,
                Specializations = mapSpecDtoToDbModel(dto.Specializations)
            )
        }

    private fun mapSpecDtoToDbModel(specializationDto: List<SpecializationDto>?) =
        specializationDto?.map {
            SpecializationDbModel(
                Name = it.Name
            )
        }

    fun mapRestDbModelToEntity(restaurantDbModel: RestaurantDbModel) =
        RestaurantEntity(
            Name = restaurantDbModel.Name,
            Logo = restaurantDbModel.Logo,
            MinCost = restaurantDbModel.MinCost,
            DeliveryCost = restaurantDbModel.DeliveryCost,
            DeliveryTime = restaurantDbModel.DeliveryTime,
            PositiveReviews = restaurantDbModel.PositiveReviews,
            ReviewsCount = restaurantDbModel.ReviewsCount,
            Specializations = mapSpecDbModelToEntity(restaurantDbModel.Specializations)
        )

    private fun mapSpecDbModelToEntity(specializationDbModel: List<SpecializationDbModel>?) =
        specializationDbModel?.map {
            SpecializationEntity(
                Name = it.Name
            )
        }
}




