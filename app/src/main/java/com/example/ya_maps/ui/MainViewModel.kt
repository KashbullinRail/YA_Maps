package com.example.ya_maps.ui

import androidx.lifecycle.*
import com.yandex.mapkit.MapKitFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(), DefaultLifecycleObserver {

    fun onStart() {
        MapKitFactory.getInstance().onStart()
        mapViewState(true)
    }

    fun onStop() {
        mapViewState(false)
        MapKitFactory.getInstance().onStop()
    }

    private var _mapViewState = MutableStateFlow<Boolean>(false)
    val mapViewState: StateFlow<Boolean> = _mapViewState.asStateFlow()

    private var _msg = MutableStateFlow<Boolean>(false)
    val msg: StateFlow<Boolean> = _msg.asStateFlow()

    private var _userLoc = MutableStateFlow<Boolean>(false)
    val userLoc: StateFlow<Boolean> = _userLoc.asStateFlow()

    private var _poligon = MutableStateFlow<Boolean>(false)
    val poligon: StateFlow<Boolean> = _poligon.asStateFlow()

    fun setMsg(value: Boolean) {
        _msg.value = value
    }

    fun userLocationOn(value: Boolean) {
        _userLoc.value = value
    }

    fun createPoligon(value: Boolean) {
       _poligon.value = value
    }

    fun mapViewState(value: Boolean) {
        _mapViewState.value = value
    }

}

