package com.gyeongmun.base.dagger.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.gyeongmun.base.dagger.data.storage.StorageModule
import io.mockk.mockk

class TestStorageModule : StorageModule() {
    override fun provideSharedPreferences(context: Context): SharedPreferences = mockk()
}
