package com.gyeongmun.base.dagger.data

import com.gyeongmun.base.dagger.data.storage.StorageModule
import com.gyeongmun.base.dagger.network.service.WeatherService
import dagger.Module
import dagger.Provides

@Module(includes = [StorageModule::class])
open class RepositoryModule {

    @Provides
    open fun provideWeatherRepository(weatherService: WeatherService): WeatherRepository {
        return WeatherRepositoryImpl(weatherService)
    }
}
