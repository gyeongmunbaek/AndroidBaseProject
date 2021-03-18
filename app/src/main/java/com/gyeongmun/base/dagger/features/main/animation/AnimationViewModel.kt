package com.gyeongmun.base.dagger.features.main.animation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gyeongmun.base.dagger.base.BaseViewModel
import javax.inject.Inject

class AnimationViewModel @Inject constructor() : BaseViewModel() {

    private val _gif = MutableLiveData<String>().apply {
        value = "52580-scooter-riding.json"
    }
    val gif: LiveData<String> = _gif
}