package com.vladlen.data.net.dto

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("html_url") val url: String
)
