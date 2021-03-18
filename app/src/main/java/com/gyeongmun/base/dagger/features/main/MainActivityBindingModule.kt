package com.gyeongmun.base.dagger.features.main

import com.gyeongmun.base.dagger.di.qualifier.FragmentScoped
import com.gyeongmun.base.dagger.features.main.dashboard.DashboardFragment
import com.gyeongmun.base.dagger.features.main.dashboard.DashboardFragmentModule
import com.gyeongmun.base.dagger.features.main.animation.AnimationFragment
import com.gyeongmun.base.dagger.features.main.animation.AnimationFragmentModule
import com.gyeongmun.base.dagger.features.main.search.SearchFragment
import com.gyeongmun.base.dagger.features.main.search.SearchFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [SearchFragmentModule::class]
    )
    abstract fun homeFragment(): SearchFragment

    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [DashboardFragmentModule::class]
    )
    abstract fun dashboardFragment(): DashboardFragment

    @FragmentScoped
    @ContributesAndroidInjector(
        modules = [AnimationFragmentModule::class]
    )
    abstract fun animationFragment(): AnimationFragment
}
