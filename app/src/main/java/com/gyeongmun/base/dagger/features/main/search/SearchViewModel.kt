package com.gyeongmun.base.dagger.features.main.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gyeongmun.base.dagger.base.BaseViewModel
import com.gyeongmun.base.dagger.data.WeatherRepository
import com.gyeongmun.base.dagger.network.response.CityResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseViewModel() {
    val text = MutableLiveData<String>()

    private val _cities = MediatorLiveData<List<CityResponse>>()
    val cities: LiveData<List<CityResponse>>
        get() = _cities

    fun searchCities(query: String) {
        viewModelScope.launch {
            weatherRepository.getCities(query).collect {
                _cities.value = it
            }
        }
    }
}