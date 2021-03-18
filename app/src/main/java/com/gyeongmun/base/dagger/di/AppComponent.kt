package com.gyeongmun.base.dagger.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.gyeongmun.base.dagger.MainApplication
import com.gyeongmun.base.dagger.data.RepositoryModule
import com.gyeongmun.base.dagger.network.NetWorkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        AppAssistedInjectModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        NetWorkModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance mainApplication: MainApplication): AppComponent
    }
}
