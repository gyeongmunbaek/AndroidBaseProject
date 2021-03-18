package com.gyeongmun.base.dagger.utils

sealed class CommonException(message: String) : Exception(message)

class CommonNetworkException(message: String) : CommonException(message)
