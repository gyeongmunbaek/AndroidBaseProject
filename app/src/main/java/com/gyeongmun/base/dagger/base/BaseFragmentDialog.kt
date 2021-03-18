package com.gyeongmun.base.dagger.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject

abstract class BaseFragmentDialog<B : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : DaggerDialogFragment() {

    protected lateinit var binding: B

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        with(binding) {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }
}
