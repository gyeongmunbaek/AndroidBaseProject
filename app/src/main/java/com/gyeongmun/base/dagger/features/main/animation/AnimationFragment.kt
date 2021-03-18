package com.gyeongmun.base.dagger.features.main.animation

import android.os.Bundle
import android.view.View
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.base.BaseFragment
import com.gyeongmun.base.dagger.databinding.FragmentAnimationBinding

class AnimationFragment : BaseFragment<AnimationViewModel, FragmentAnimationBinding>(
    AnimationViewModel::class,
    R.layout.fragment_animation
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "AnimationFragment"
    }
}