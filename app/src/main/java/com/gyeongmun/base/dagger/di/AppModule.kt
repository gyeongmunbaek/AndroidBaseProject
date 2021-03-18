package com.gyeongmun.base.dagger.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.gyeongmun.base.dagger.MainApplication
import javax.inject.Singleton

@Module
open class AppModule {

    @Singleton
    @Provides
    open fun provideContext(app: MainApplication): Context = app.applicationContext

    @Singleton
    @Provides
    open fun provideApplication(): Application = MainApplication()
}
