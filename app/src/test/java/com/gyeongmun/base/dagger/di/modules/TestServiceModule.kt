package com.gyeongmun.base.dagger.di.modules

import com.gyeongmun.base.dagger.network.ServiceModule
import com.gyeongmun.base.dagger.network.service.WeatherService
import io.mockk.mockk
import retrofit2.Retrofit

class TestServiceModule : ServiceModule() {
    override fun provideWeatherService(retrofit: Retrofit): WeatherService = mockk()
}