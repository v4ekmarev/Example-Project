package com.vladlen.data.net.dto

import com.google.gson.annotations.SerializedName

data class BookListDto(
    @SerializedName("items") val items: List<BookItemDTO>
)
