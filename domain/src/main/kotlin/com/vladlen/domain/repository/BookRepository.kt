package com.vladlen.domain.repository

import com.vladlen.domain.model.Book
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface BookRepository {

    val isConnected: Boolean

    //region LIST BOOK

    fun getBookList(query: String) : Single<List<Book>>

    fun getCashedBookList(query: String) : Single<List<Book>>

    fun getCashedFavoriteListBook(isFavorite: Boolean): Flowable<List<Book>>

    fun saveListBook(bookList: List<Book>): Completable

    //endregion

    //region BOOK

    fun saveFavoriteBook(book: Book): Completable

    //endregion

}
