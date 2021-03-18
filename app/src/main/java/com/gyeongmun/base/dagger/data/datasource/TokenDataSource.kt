package com.gyeongmun.base.dagger.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit

class TokenDataSourceImpl(private val sharedPreferences: SharedPreferences) : TokenDataSource {

    companion object {
        const val TOKEN = "TOKEN"
    }

    override fun getToken(): String {
        return sharedPreferences.getString(TOKEN, "").orEmpty()
    }

    override fun setToken(token: String) {
        sharedPreferences.edit {
            putString(TOKEN, token)
        }
    }

    override fun deleteToken() {
        sharedPreferences.edit {
            remove(TOKEN)
        }
    }
}

interface TokenDataSource {

    fun getToken(): String

    fun setToken(token: String)

    fun deleteToken()
}
