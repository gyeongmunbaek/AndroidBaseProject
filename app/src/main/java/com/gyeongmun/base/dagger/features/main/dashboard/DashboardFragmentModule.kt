package com.gyeongmun.base.dagger.features.main.dashboard

import androidx.lifecycle.ViewModel
import com.gyeongmun.base.dagger.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DashboardFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun bindViewModel(viewModel: DashboardViewModel): ViewModel
}
