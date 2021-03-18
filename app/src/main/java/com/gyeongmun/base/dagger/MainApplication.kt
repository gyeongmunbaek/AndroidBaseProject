package com.gyeongmun.base.dagger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.gyeongmun.base.dagger.di.DaggerAppComponent

open class MainApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    companion object {

        private var instance: MainApplication? = null

        fun getInstance(): MainApplication {
            if (instance == null) {
                instance = MainApplication()
            }

            return instance!!
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}
