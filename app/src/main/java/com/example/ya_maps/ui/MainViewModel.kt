package com.example.ya_maps.ui

import androidx.lifecycle.*
import com.yandex.mapkit.MapKitFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(), DefaultLifecycleObserver {

    fun onStart() {
        MapKitFactory.getInstance().onStart()
        // start task - the composable has entered the composition
    }

    fun onStop() {
        MapKitFactory.getInstance().onStop()
        // cancel task - the composable has left the composition
    }

    private var _msg = MutableStateFlow<Boolean>(false)
    val msg: StateFlow<Boolean> = _msg.asStateFlow()

    fun setMsg(value: Boolean) {
        _msg.value = value
    }

}

