package com.vladlen.data.net.api

import com.vladlen.data.net.dto.BookDTO
import com.vladlen.data.net.dto.BookListDto
import com.vladlen.domain.model.Book
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {

    @GET("?maxResults=10")
    fun getListBooks(@Query("q") query: String): Single<BookListDto>

    @GET("{id}")
    fun getBook(@Path("id") id: String?): Single<BookDTO>

}
