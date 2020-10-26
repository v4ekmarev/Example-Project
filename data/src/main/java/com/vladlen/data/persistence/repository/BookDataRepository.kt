package com.vladlen.data.persistence.repository

import com.vladlen.data.di.providers.NetworkChecker
import com.vladlen.data.mapper.BookMapper
import com.vladlen.data.net.api.GoogleBooksApi
import com.vladlen.data.persistence.dao.BookDao
import com.vladlen.domain.model.Book
import com.vladlen.domain.repository.BookRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * [BookRepository] for retrieving repo data.
 */
class BookDataRepository @Inject constructor(
    private val googleBooksApi: GoogleBooksApi,
    private val bookDao: BookDao,
    private val bookMapper: BookMapper,
    private val networkChecker: NetworkChecker
) : BookRepository {

    override val isConnected: Boolean
        get() = networkChecker.isConnected

    //region LIST BOOK
    override fun getBookList(query: String): Single<List<Book>> {
        return googleBooksApi.getListBooks(query)
            .flatMap { bookListDto ->
                return@flatMap Observable.fromIterable(bookListDto.items)
                    .flatMapSingle { bookDto ->
                        googleBooksApi.getBook(bookDto.id)
                    }.toList()
            }
            .map {
                bookMapper.transformDto(it)
            }
    }

    override fun getCashedBookList(query: String): Single<List<Book>> {
        return bookDao.getAll()
            .map {
                bookMapper.transformEntity(it)
            }
    }

    override fun getCashedFavoriteListBook(isFavorite: Boolean): Flowable<List<Book>> {
        return bookDao.getIsFavoriteBook(isFavorite)
            .map {
                bookMapper.transformEntity(it)
            }
    }

    override fun saveListBook(bookList: List<Book>): Completable {
        TODO("Not yet implemented")
    }
    //endregion

    //region BOOK
    override fun saveFavoriteBook(book: Book): Completable {
        return bookDao.insertFavoriteBook(bookMapper.transformToEntity(book))
    }
    //endregion
}
