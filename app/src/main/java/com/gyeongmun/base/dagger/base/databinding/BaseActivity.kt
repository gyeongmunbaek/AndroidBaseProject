package com.gyeongmun.base.dagger.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import com.gyeongmun.base.dagger.BR
import com.gyeongmun.base.dagger.di.viewModel
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding>(
    viewModelClass: KClass<VM>,
    @LayoutRes val layoutResId: Int
) : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val viewModel: VM by viewModel(viewModelClass) { viewModelFactory }

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        with(binding) {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@BaseActivity
        }
    }
}
