package com.vladlen.domain.model

data class Book(
    val id: Long,
    val authorName: String,
    val description: String,
    val link: String,
    val isFavorite: Boolean,
)