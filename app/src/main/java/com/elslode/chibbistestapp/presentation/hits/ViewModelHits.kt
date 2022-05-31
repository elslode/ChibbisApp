package com.elslode.chibbistestapp.presentation.hits

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elslode.chibbistestapp.domain.GetHitsListUseCase
import com.elslode.chibbistestapp.domain.LoadHitsUseCase
import com.elslode.chibbistestapp.domain.hits.HitsEntity
import com.elslode.chibbistestapp.presentation.StateResource
import kotlinx.coroutines.*
import javax.inject.Inject

class ViewModelHits @Inject constructor(
    private val getHitsListUseCase: GetHitsListUseCase,
    private val loadHitsUseCase: LoadHitsUseCase,
) : ViewModel() {

    private val _hitsList = MutableLiveData<StateResource<List<HitsEntity>>>()
    val hitsList: MutableLiveData<StateResource<List<HitsEntity>>>
        get() = _hitsList

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _hitsList.postValue(StateResource.error(throwable.message.toString(), null))
    }

    private val jobGetListHits = CoroutineScope(Dispatchers.IO + exceptionHandler)

    init {
        _hitsList.postValue(StateResource.loading(null))
        jobGetListHits.launch {
            loadHitsUseCase.invoke()
            _hitsList.postValue(StateResource.success(getHitsListUseCase()))
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobGetListHits.cancel()
    }
}