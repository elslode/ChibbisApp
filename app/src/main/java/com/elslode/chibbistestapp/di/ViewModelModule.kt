package com.elslode.chibbistestapp.di

import androidx.lifecycle.ViewModel
import com.elslode.chibbistestapp.presentation.hits.ViewModelHits
import com.elslode.chibbistestapp.presentation.restaurants.ViewModelRestaurants
import com.elslode.chibbistestapp.presentation.review.ViewModelReviews
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelHits::class)
    fun bindHitsViewModule(vmHits: ViewModelHits): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelRestaurants::class)
    fun bindRestaurantsViewModule(vmRestaurant: ViewModelRestaurants): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReviews::class)
    fun bindReviewViewModule(vmReview: ViewModelReviews): ViewModel
}