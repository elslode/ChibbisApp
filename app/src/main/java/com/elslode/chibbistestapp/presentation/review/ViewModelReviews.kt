package com.elslode.chibbistestapp.presentation.review

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elslode.chibbistestapp.domain.GetReviewListUseCase
import com.elslode.chibbistestapp.domain.LoadReviewListUseCase
import com.elslode.chibbistestapp.domain.review.ReviewsEntity
import com.elslode.chibbistestapp.presentation.StateResource
import kotlinx.coroutines.*
import javax.inject.Inject

class ViewModelReviews @Inject constructor(
    private val getReviewListUseCase: GetReviewListUseCase,
    private val loadReviewListUseCase: LoadReviewListUseCase
): ViewModel() {

    private val _reviewList = MutableLiveData<StateResource<List<ReviewsEntity>>>()
    val reviewList: MutableLiveData<StateResource<List<ReviewsEntity>>>
        get() = _reviewList

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _reviewList.postValue(StateResource.error(throwable.message.toString(), null))
    }

    private val jobGetListReview = CoroutineScope(Dispatchers.IO + exceptionHandler)

    init {
        _reviewList.postValue(StateResource.loading(null))
        jobGetListReview.launch {
            loadReviewListUseCase.invoke()
            _reviewList.postValue(StateResource.success(getReviewListUseCase()))
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobGetListReview.cancel()
    }
}