package com.vladlen.domain.model

data class Book(
    val id: String,
    val title: String,
    val link: String,
    val imgLink: String,
    val isFavorite: Boolean,
)