package com.example.uas_mobile.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.BreakingBadPhoto
import com.example.uas_mobile.network.DisneyApi
import com.example.uas_mobile.network.DisneyApi2
import com.example.uas_mobile.network.DisneyPhoto
import kotlinx.coroutines.launch

class SlideshowViewModel : ViewModel() {
    private val _photos = MutableLiveData<List<BreakingBadPhoto>>()
    val photos: LiveData<List<BreakingBadPhoto>> = _photos

    private val _status = MutableLiveData<DisneyApiStatus2>()
    val status: LiveData<DisneyApiStatus2> = _status

    init {
        getMarsPhotos()
    }

    enum class DisneyApiStatus2 { LOADING, ERROR, DONE }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = DisneyApiStatus2.LOADING
            try {
                _photos.value = DisneyApi2.retrofitService.getPhotos()
                _status.value = DisneyApiStatus2.DONE
            } catch (e: Exception) {
                _status.value = DisneyApiStatus2.ERROR
                _photos.value = listOf()
            }
        }
    }
}