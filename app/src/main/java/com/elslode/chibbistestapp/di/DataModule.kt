package com.elslode.chibbistestapp.di

import android.app.Application
import android.content.Context
import com.elslode.chibbistestapp.data.database.AppDatabase
import com.elslode.chibbistestapp.data.database.HitsDao
import com.elslode.chibbistestapp.data.database.RestaurantDao
import com.elslode.chibbistestapp.data.database.ReviewDao
import com.elslode.chibbistestapp.data.network.ApiFactory
import com.elslode.chibbistestapp.data.network.ApiService
import com.elslode.chibbistestapp.data.repository.HitsRepositoryImpl
import com.elslode.chibbistestapp.data.repository.RestaurantsRepositoryImpl
import com.elslode.chibbistestapp.data.repository.ReviewRepositoryImpl
import com.elslode.chibbistestapp.domain.HitsRepository
import com.elslode.chibbistestapp.domain.RestaurantRepository
import com.elslode.chibbistestapp.domain.ReviewRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindsRepository(impl: RestaurantsRepositoryImpl): RestaurantRepository

    @Binds
    fun bindsRepositoryHits(impl: HitsRepositoryImpl): HitsRepository

    @Binds
    fun bindsRepositoryReview(impl: ReviewRepositoryImpl): ReviewRepository

    companion object {

        @Provides
        fun providesApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        fun providesRestaurantsDao(application: Application): RestaurantDao {
            return AppDatabase.getInstance(application).restaurantDao()
        }

        @Provides
        fun providesHitsDao(application: Application): HitsDao {
            return AppDatabase.getInstance(application).hitsDao()
        }

        @Provides
        fun providesReviewDao(application: Application): ReviewDao {
            return AppDatabase.getInstance(application).reviewDao()
        }

        @Provides
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }
    }
}