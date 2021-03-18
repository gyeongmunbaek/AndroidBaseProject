package com.gyeongmun.base.dagger.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

inline fun <VM : ViewModel> FragmentActivity.viewModel(
    viewModelClass: KClass<VM>,
    crossinline body: () -> ViewModelProvider.Factory
): Lazy<VM> {
    return lazy {
        ViewModelProvider(this, body()).get(viewModelClass.java)
    }
}

inline fun <VM : ViewModel> Fragment.viewModel(
    viewModelClass: KClass<VM>,
    crossinline body: () -> ViewModelProvider.Factory
): Lazy<VM> {
    return lazy {
        ViewModelProvider(this, body()).get(viewModelClass.java)
    }
}

inline fun <VM : ViewModel> Fragment.parentViewModel(
    viewModelClass: KClass<VM>,
    crossinline body: () -> ViewModelProvider.Factory
): Lazy<VM> {
    return lazy {
        ViewModelProvider(requireActivity(), body()).get(viewModelClass.java)
    }
}
