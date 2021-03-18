package com.gyeongmun.base.dagger.di.modules

import com.gyeongmun.base.dagger.di.qualifier.ActivityScoped
import com.gyeongmun.base.dagger.di.qualifier.FragmentScoped
import com.gyeongmun.base.dagger.features.main.MainActivity
import com.gyeongmun.base.dagger.features.main.MainActivityBindingModule
import com.gyeongmun.base.dagger.features.main.MainActivityModule
import com.gyeongmun.base.dagger.features.main.dashboard.DashboardFragmentModule
import com.gyeongmun.base.dagger.tests.TestDashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestUIActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainActivityBindingModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity

    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [DashboardFragmentModule::class]
    )
    abstract fun dashboardFragment(): TestDashboardFragment
}
