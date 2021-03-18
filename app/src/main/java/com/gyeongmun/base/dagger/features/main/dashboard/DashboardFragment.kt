package com.gyeongmun.base.dagger.features.main.dashboard

import android.os.Bundle
import android.view.View
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.base.BaseFragment
import com.gyeongmun.base.dagger.databinding.FragmentDashboardBinding

open class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>(
    DashboardViewModel::class,
    R.layout.fragment_dashboard
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "DashboardFragment"
    }
}