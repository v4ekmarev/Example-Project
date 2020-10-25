package com.vladlen.data.net.api

import com.vladlen.data.net.dto.BookDTO
import com.vladlen.domain.model.Book
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleBooksApi {

    @GET("?maxResults=10")
    fun getListBooks(@Path("q") query: String): Single<List<BookDTO>>

    @GET("{id}")
    fun getBook(@Path("id") id: String?): Single<Book>

}
