package com.gyeongmun.base.dagger.features.main.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gyeongmun.base.dagger.base.BaseViewModel
import javax.inject.Inject

class NotificationsViewModel @Inject constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}