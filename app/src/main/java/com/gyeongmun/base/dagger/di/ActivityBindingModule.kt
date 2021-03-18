package com.gyeongmun.base.dagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.gyeongmun.base.dagger.di.qualifier.ActivityScoped
import com.gyeongmun.base.dagger.features.main.MainActivity
import com.gyeongmun.base.dagger.features.main.MainActivityBindingModule
import com.gyeongmun.base.dagger.features.main.MainActivityModule

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainActivityBindingModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}
