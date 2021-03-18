package com.gyeongmun.base.dagger.tests

import com.gyeongmun.base.dagger.di.components.DaggerTestAppComponent
import com.gyeongmun.base.dagger.di.modules.TestAppModule
import com.gyeongmun.base.dagger.di.modules.TestNetWorkModule
import com.gyeongmun.base.dagger.di.modules.TestServiceModule
import com.gyeongmun.base.dagger.network.response.CityResponse
import com.gyeongmun.base.dagger.network.service.WeatherService
import com.gyeongmun.base.dagger.rules.CoroutinesRule
import io.mockk.every
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@RunWith(JUnit4::class)
class WeatherRepositoryTest {
    @get:Rule
    var mainCoroutineRule = CoroutinesRule()

    @Inject
    lateinit var weatherAPI: WeatherService

    @Before
    fun start() {
        val component = DaggerTestAppComponent.builder()
            .appModule(TestAppModule())
            .netWorkModule(TestNetWorkModule())
            .serviceModule(TestServiceModule())
            .build()
        component.into(this)
    }

    @Test
    fun `weather service test`() = runBlocking {
        Assert.assertNotNull(weatherAPI)

        val costTimeMillis = measureTimeMillis {
            every { runBlocking { weatherAPI.getCities("g") } } returns listOf(
                CityResponse(title = "Birmingham"),
                CityResponse(title = "Los Angeles")
            )
            val result = weatherAPI.getCities("g")
            Assert.assertEquals(
                result,
                listOf(CityResponse(title = "Birmingham"), CityResponse(title = "Los Angeles"))
            )
        }
        print("costTimeMillis: $costTimeMillis")
    }
}