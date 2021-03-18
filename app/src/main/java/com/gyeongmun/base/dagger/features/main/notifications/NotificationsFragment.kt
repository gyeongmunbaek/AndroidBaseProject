package com.gyeongmun.base.dagger.features.main.notifications

import android.os.Bundle
import android.view.View
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.base.BaseFragment
import com.gyeongmun.base.dagger.databinding.FragmentNotificationsBinding

class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>(
    NotificationsViewModel::class,
    R.layout.fragment_notifications
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "NotificationsFragment"
    }
}