package com.gyeongmun.base.dagger.features.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.base.BaseActivity
import com.gyeongmun.base.dagger.databinding.ActivityMainBinding
import com.gyeongmun.base.dagger.features.main.dashboard.DashboardFragment
import com.gyeongmun.base.dagger.features.main.notifications.NotificationsFragment
import com.gyeongmun.base.dagger.features.main.search.SearchFragment

const val STACK_FRAGMENT_NAVIGATION = false

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    MainViewModel::class,
    R.layout.activity_main
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        if (STACK_FRAGMENT_NAVIGATION) {
            setFragment(SearchFragment.TAG, SearchFragment())
            navView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_search -> setFragment(SearchFragment.TAG, SearchFragment())
                    R.id.navigation_dashboard -> setFragment(
                        DashboardFragment.TAG,
                        DashboardFragment()
                    )
                    R.id.navigation_notifications -> setFragment(
                        NotificationsFragment.TAG,
                        NotificationsFragment()
                    )
                }

                true
            }
        } else {
            val navController = findNavController(R.id.nav_host_fragment)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_search, R.id.navigation_dashboard, R.id.navigation_notifications
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }


    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            ft.add(R.id.nav_host_fragment, fragment, tag)
        }

        val search = manager.findFragmentByTag(SearchFragment.TAG)
        val dashboard = manager.findFragmentByTag(DashboardFragment.TAG)
        val notification = manager.findFragmentByTag(NotificationsFragment.TAG)

        // Hide all Fragment
        if (search != null) {
            ft.hide(search)
        }
        if (dashboard != null) {
            ft.hide(dashboard)
        }
        if (notification != null) {
            ft.hide(notification)
        }

        // Show  current Fragment
        when (tag) {
            SearchFragment.TAG ->
                if (search != null) {
                    ft.show(search)
                }
            DashboardFragment.TAG ->
                if (dashboard != null) {
                    ft.show(dashboard)
                }
            NotificationsFragment.TAG ->
                if (notification != null) {
                    ft.show(notification)
                }
        }

        ft.commitAllowingStateLoss()
    }
}