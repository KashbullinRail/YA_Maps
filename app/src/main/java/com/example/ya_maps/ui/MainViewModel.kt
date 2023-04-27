package com.example.ya_maps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    fun setMsg(count: Int) {
        _msg.value = count
    }

}