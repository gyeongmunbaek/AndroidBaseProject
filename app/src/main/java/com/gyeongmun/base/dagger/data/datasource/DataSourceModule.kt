package com.gyeongmun.base.dagger.data.datasource

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DataSourceModule {

    @Singleton
    @Provides
    open fun provideTokenDataSource(sharedPreferences: SharedPreferences): TokenDataSource {
        return TokenDataSourceImpl(sharedPreferences)
    }
}
