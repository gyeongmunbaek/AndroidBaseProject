package com.gyeongmun.base.dagger.features.main.notifications

import androidx.lifecycle.ViewModel
import com.gyeongmun.base.dagger.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NotificationsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    internal abstract fun bindViewModel(viewModel: NotificationsViewModel): ViewModel
}
