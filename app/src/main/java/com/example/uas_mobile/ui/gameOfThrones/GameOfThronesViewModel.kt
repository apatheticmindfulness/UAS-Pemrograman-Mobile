package com.example.uas_mobile.ui.gameOfThrones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile.network.DisneyApi
import com.example.uas_mobile.network.GameOfThronesData
import kotlinx.coroutines.launch

class GameOfThronesViewModel : ViewModel() {

    private val _photos = MutableLiveData<List<GameOfThronesData>>()
    val photos: LiveData<List<GameOfThronesData>> = _photos

    private val _status = MutableLiveData<DisneyApiStatus>()
    val status: LiveData<DisneyApiStatus> = _status

    init {
        getMarsPhotos()
    }

    enum class DisneyApiStatus { LOADING, ERROR, DONE }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = DisneyApiStatus.LOADING
            try {
                _photos.value = DisneyApi.retrofitService.getPhotos()
                _status.value = DisneyApiStatus.DONE
            } catch (e: Exception) {
                _status.value = DisneyApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}