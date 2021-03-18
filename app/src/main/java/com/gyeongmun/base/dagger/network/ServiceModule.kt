package com.gyeongmun.base.dagger.network

import com.gyeongmun.base.dagger.network.service.WeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
open class ServiceModule {
    @Provides
    open fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)
}
