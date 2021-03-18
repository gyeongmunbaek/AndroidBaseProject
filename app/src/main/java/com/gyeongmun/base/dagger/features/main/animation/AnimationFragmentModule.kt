package com.gyeongmun.base.dagger.features.main.animation

import androidx.lifecycle.ViewModel
import com.gyeongmun.base.dagger.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AnimationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(AnimationViewModel::class)
    internal abstract fun bindViewModel(viewModel: AnimationViewModel): ViewModel
}
