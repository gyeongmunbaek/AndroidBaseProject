package com.gyeongmun.base.dagger.di.components

import com.gyeongmun.base.dagger.MainApplication
import com.gyeongmun.base.dagger.UiMainApplication
import com.gyeongmun.base.dagger.data.RepositoryModule
import com.gyeongmun.base.dagger.di.AppAssistedInjectModule
import com.gyeongmun.base.dagger.di.AppModule
import com.gyeongmun.base.dagger.di.ViewModelModule
import com.gyeongmun.base.dagger.di.modules.TestUIActivityBindingModule
import com.gyeongmun.base.dagger.network.NetWorkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        AppAssistedInjectModule::class,
        TestUIActivityBindingModule::class,
        ViewModelModule::class,
        NetWorkModule::class,
        RepositoryModule::class,
    ]
)
interface TestUIAppComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance mainApplication: UiMainApplication): TestUIAppComponent
    }
}
