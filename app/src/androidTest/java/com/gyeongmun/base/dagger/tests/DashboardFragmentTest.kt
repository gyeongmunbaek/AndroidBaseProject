package com.gyeongmun.base.dagger.tests

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.features.main.dashboard.DashboardFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardFragmentTest {
    @Test
    fun testFragment() {
        // The "fragmentArgs" and "factory" arguments are optional.
        val scenario = launchFragmentInContainer<TestDashboardFragment>()
        onView(withId(R.id.text_dashboard)).check(matches(withText("This is dashboard Fragment")))
        assert(true)
    }
}

class TestDashboardFragment : DashboardFragment()