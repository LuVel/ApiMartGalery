package com.example.apimartgalery.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apimartgalery.network.MarsApi
import com.example.apimartgalery.network.MarsPhoto
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    var marsPhotos by mutableStateOf<List<MarsPhoto>>(emptyList())
        private set

    fun getMarsPhotos() {
        viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            marsPhotos = listResult
        }
    }
}