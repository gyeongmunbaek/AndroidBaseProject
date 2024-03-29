package com.gyeongmun.base.dagger.base.databinding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import com.gyeongmun.base.dagger.BR
import com.gyeongmun.base.dagger.di.viewModel
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseBottomFragmentDialog<VM : ViewModel, B : ViewDataBinding>(
    viewModelClass: KClass<VM>,
    @LayoutRes val layoutResId: Int
) : BottomSheetDialogFragment() {

    lateinit var binding: B

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val viewModel: VM by viewModel(viewModelClass) { viewModelFactory }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        with(binding) {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }
}
