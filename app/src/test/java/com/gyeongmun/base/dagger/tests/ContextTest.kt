package com.gyeongmun.base.dagger.tests

import android.app.Application
import com.gyeongmun.base.dagger.di.components.DaggerTestAppComponent
import com.gyeongmun.base.dagger.di.modules.TestAppModule
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class ContextTest {
    @Inject
    lateinit var application: Application

    @Before
    fun setUp() {
        val component = DaggerTestAppComponent.builder()
            .appModule(TestAppModule())
            .build()
        component.into(this)
    }

    @Test
    fun `application test`() {
        Assert.assertNotNull(application)
    }
}