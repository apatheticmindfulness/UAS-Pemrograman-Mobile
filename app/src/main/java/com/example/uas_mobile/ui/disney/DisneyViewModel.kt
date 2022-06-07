package com.example.uas_mobile.ui.disney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.DisneyApi
import com.example.uas_mobile.network.DisneyPhoto
import kotlinx.coroutines.launch

class DisneyViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<DisneyPhoto>>()
    val photos: LiveData<List<DisneyPhoto>> = _photos

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    init {
        getMarsPhotos()
    }


    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = DisneyApi.retrofitService.getPhotos()
                _photos.value = DisneyApi.retrofitService.getPhotos()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}