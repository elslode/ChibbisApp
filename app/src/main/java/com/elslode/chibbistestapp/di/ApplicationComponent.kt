package com.elslode.chibbistestapp.di

import android.app.Application
import com.elslode.chibbistestapp.presentation.hits.HitsFragment
import com.elslode.chibbistestapp.presentation.restaurants.RestaurantFragment
import com.elslode.chibbistestapp.presentation.review.ReviewFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)

interface ApplicationComponent {

    fun inject(restaurantFragment: RestaurantFragment)
    fun inject(hitsFragment: HitsFragment)
    fun inject(reviewFragment: ReviewFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
