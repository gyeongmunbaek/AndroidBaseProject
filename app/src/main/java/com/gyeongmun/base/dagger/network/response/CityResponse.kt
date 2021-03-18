package com.gyeongmun.base.dagger.network.response

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val locationType: String? = null,
    @SerializedName("latt_long")
    val lattLong: String? = null,
    @SerializedName("woeid")
    val woeid: Int? = null,
    @SerializedName("distance")
    val distance: Int? = null
)
