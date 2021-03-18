package com.gyeongmun.base.dagger.features.main.search

import androidx.lifecycle.ViewModel
import com.gyeongmun.base.dagger.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun bindViewModel(viewModel: SearchViewModel): ViewModel
}
