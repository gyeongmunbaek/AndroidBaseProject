package com.gyeongmun.base.dagger.di.modules

import android.app.Application
import android.content.Context
import com.gyeongmun.base.dagger.MainApplication
import com.gyeongmun.base.dagger.di.AppModule
import io.mockk.mockk

class TestAppModule : AppModule() {
    override fun provideContext(app: MainApplication): Context = mockk()

    override fun provideApplication(): Application = mockk()
}