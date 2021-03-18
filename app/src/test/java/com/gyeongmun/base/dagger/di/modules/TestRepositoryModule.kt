package com.gyeongmun.base.dagger.di.modules

import com.gyeongmun.base.dagger.data.RepositoryModule
import com.gyeongmun.base.dagger.data.WeatherRepository
import com.gyeongmun.base.dagger.network.service.WeatherService
import io.mockk.mockk

class TestRepositoryModule : RepositoryModule() {
    override fun provideWeatherRepository(
        weatherService: WeatherService,
    ): WeatherRepository =
        mockk()
}
