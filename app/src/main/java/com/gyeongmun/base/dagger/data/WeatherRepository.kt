package com.gyeongmun.base.dagger.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.gyeongmun.base.dagger.network.response.CityResponse
import com.gyeongmun.base.dagger.network.service.WeatherService

class WeatherRepositoryImpl(
    private val weatherService: WeatherService,
) : WeatherRepository {
    override fun getCities(query: String): Flow<List<CityResponse>> {
        return flow { emit(weatherService.getCities(query)) }.flowOn(Dispatchers.IO)
    }
}

interface WeatherRepository {
    fun getCities(query: String): Flow<List<CityResponse>>
}
