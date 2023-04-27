package com.example.ya_maps.ui

import androidx.lifecycle.*
import com.yandex.mapkit.MapKitFactory

class MainViewModel : ViewModel(), DefaultLifecycleObserver {

    fun onStart() {
        MapKitFactory.getInstance().onStart()
        // start task - the composable has entered the composition
    }

    fun onStop() {
        MapKitFactory.getInstance().onStop()
        // cancel task - the composable has left the composition
    }

    private var _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    fun setMsg(count: Int) {
        _msg.value = count
    }

}

