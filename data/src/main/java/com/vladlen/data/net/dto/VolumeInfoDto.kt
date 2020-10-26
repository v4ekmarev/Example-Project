package com.vladlen.data.net.dto

import com.google.gson.annotations.SerializedName

data class VolumeInfoDto(
    @SerializedName("imageLinks") val imageLinks: ImageLinksDto,
    @SerializedName("title") val title: String
)