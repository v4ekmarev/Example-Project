package com.vladlen.data.net.dto

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("id") val id: String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfoDto,
    @SerializedName("selfLink") val url: String
)
