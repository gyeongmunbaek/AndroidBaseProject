package com.gyeongmun.base.dagger.di.components

import com.gyeongmun.base.dagger.data.RepositoryModule
import com.gyeongmun.base.dagger.di.AppComponent
import com.gyeongmun.base.dagger.di.AppModule
import com.gyeongmun.base.dagger.network.NetWorkModule
import com.gyeongmun.base.dagger.network.ServiceModule
import com.gyeongmun.base.dagger.tests.ContextTest
import com.gyeongmun.base.dagger.tests.WeatherRepositoryTest
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        RepositoryModule::class,
        NetWorkModule::class,
        ServiceModule::class,
    ]
)
interface TestAppComponent : AppComponent {
    fun into(contextTest: ContextTest)
    fun into(weatherRepositoryTest: WeatherRepositoryTest)
}