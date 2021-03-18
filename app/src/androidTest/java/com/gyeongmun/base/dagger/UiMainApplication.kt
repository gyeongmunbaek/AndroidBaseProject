package com.gyeongmun.base.dagger

import com.gyeongmun.base.dagger.di.components.DaggerTestUIAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class UiMainApplication : MainApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestUIAppComponent.factory().create(this)
    }
}