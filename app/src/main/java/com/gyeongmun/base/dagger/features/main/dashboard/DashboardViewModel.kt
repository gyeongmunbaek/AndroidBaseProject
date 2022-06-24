package com.gyeongmun.base.dagger.features.main.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gyeongmun.base.dagger.base.databinding.BaseViewModel
import javax.inject.Inject

class DashboardViewModel @Inject constructor() :
    BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}