package com.gyeongmun.base.dagger.network.request

import com.google.gson.annotations.SerializedName

data class CityRequest(
    @SerializedName("biokit_code")
    val bioKitCode: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("address_extra")
    val addressExtra: String,
    @SerializedName("zipcode")
    val zipCode: String
)
