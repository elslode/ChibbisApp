package com.elslode.chibbistestapp.presentation.restaurants

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elslode.chibbistestapp.domain.GetRestaurantsListUseCase
import com.elslode.chibbistestapp.domain.LoadRestaurantListUseCase
import com.elslode.chibbistestapp.domain.restaurantEntity.RestaurantEntity
import com.elslode.chibbistestapp.presentation.StateResource
import kotlinx.coroutines.*
import javax.inject.Inject

class ViewModelRestaurants @Inject constructor(
    private val getRestaurantsListUseCase: GetRestaurantsListUseCase,
    private val loadRestaurantListUseCase: LoadRestaurantListUseCase
): ViewModel() {

    private val _restaurantList = MutableLiveData<StateResource<List<RestaurantEntity>>>()
    val restaurantList: MutableLiveData<StateResource<List<RestaurantEntity>>>
        get() = _restaurantList

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _restaurantList.postValue(StateResource.error(throwable.message.toString(), null))
    }

    private val jobGetListRestaurants = CoroutineScope(Dispatchers.IO + exceptionHandler)

    init {
        _restaurantList.postValue(StateResource.loading(null))
        jobGetListRestaurants.launch {
            loadRestaurantListUseCase.invoke()
            _restaurantList.postValue(StateResource.success(getRestaurantsListUseCase()))
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobGetListRestaurants.cancel()
    }

    companion object {
        private const val TAG = "GET_RESTAURANT_LIST"
    }
}