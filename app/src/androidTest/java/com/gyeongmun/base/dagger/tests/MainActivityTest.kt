package com.gyeongmun.base.dagger.tests

import android.content.Intent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gyeongmun.base.dagger.R
import com.gyeongmun.base.dagger.features.main.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setupData() {
        activityScenario = ActivityScenario.launch(
            Intent(
                ApplicationProvider.getApplicationContext(),
                MainActivity::class.java
            )
        )
    }

    @After
    fun close() {
        activityScenario.close()
    }

    @Test
    fun testActivity() {
        activityScenario.onActivity {
            (it.findViewById<ConstraintLayout>(R.id.container))?.let {
                assert(true)
            }
        }
    }

    @Test
    fun moveToStateTest() {
        activityScenario.moveToState(Lifecycle.State.STARTED)
        Assert.assertEquals(activityScenario.state, Lifecycle.State.STARTED)

        activityScenario.moveToState(Lifecycle.State.CREATED)
        Assert.assertEquals(activityScenario.state, Lifecycle.State.CREATED)

        activityScenario.moveToState(Lifecycle.State.RESUMED)
        Assert.assertEquals(activityScenario.state, Lifecycle.State.RESUMED)

        activityScenario.moveToState(Lifecycle.State.DESTROYED)
        Assert.assertEquals(activityScenario.state, Lifecycle.State.DESTROYED)

        // activityScenario.recreate()
    }
}