package com.gyeongmun.base.dagger.di.modules

import com.gyeongmun.base.dagger.network.NetWorkModule
import io.mockk.mockk
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named

class TestNetWorkModule : NetWorkModule() {
    override fun provideLoggingInterceptor(): HttpLoggingInterceptor = mockk()

    override fun provideErrorInterceptor(): Interceptor = mockk()

    override fun provideWeatherOkHttpClient(
        logger: HttpLoggingInterceptor,
        @Named("errorInterceptor") errorInterceptor: Interceptor,
    ): OkHttpClient = mockk()

    override fun provideWeatherRetrofit(@Named("weatherOkHttpClient") okHttpClient: OkHttpClient): Retrofit =
        mockk()
}
