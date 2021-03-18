package com.gyeongmun.base.dagger.network

import com.gyeongmun.base.dagger.BuildConfig
import com.gyeongmun.base.dagger.utils.CommonNetworkException
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ServiceModule::class])
open class NetWorkModule {

    private companion object {
        private const val TIMEOUT: Long = 15
        private const val WEATHER_URL = "https://www.metaweather.com"
    }

    @Provides
    open fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Named("errorInterceptor")
    open fun provideErrorInterceptor() = Interceptor {
        it.proceed(it.request()).apply {
            if (code >= 400) {
                Timber.e(
                    CommonNetworkException(
                        "Method : ${request.method}\n" +
                                "Code : ${code}\n" +
                                "Url : ${request.url}\n" +
                                "Headers\n${request.headers}\n" +
                                "Body : ${request.body}"
                    )
                )
            }
        }.newBuilder().build()
    }

    @Provides
    @Named("weatherOkHttpClient")
    open fun provideWeatherOkHttpClient(
        logger: HttpLoggingInterceptor,
        @Named("errorInterceptor") errorInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(errorInterceptor)
            .addInterceptor(logger)
            .build()
    }

    @Singleton
    @Provides
    open fun provideWeatherRetrofit(@Named("weatherOkHttpClient") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
