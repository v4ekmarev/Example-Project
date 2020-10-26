package com.vladlen.domain.usecases

import com.vladlen.domain.functions.StatementSingle
import com.vladlen.domain.model.Book
import com.vladlen.domain.repository.BookRepository
import com.vladlen.domain.usecases.base.SingleUseCase
import com.vladlen.domain.usecases.base.UseCaseScheduler
import io.reactivex.Single
import javax.inject.Inject

class GetBookListUseCase @Inject constructor(
    private val bookRepository: BookRepository,
    useCaseScheduler: UseCaseScheduler? = null
) : SingleUseCase<Collection<Book>, String>(useCaseScheduler) {

    override fun build(param: String): Single<Collection<Book>> {
        val cacheFavoriteSingle =
            bookRepository.getCashedFavoriteListBook(true).firstOrError().cache()

        val cacheSingle = bookRepository.getCashedBookList(param).zipWith(cacheFavoriteSingle,
            { cacheBook, cacheFavoriteBook ->
                cacheBook.forEach { book ->
                    cacheFavoriteBook.find { favoriteBook ->
                        favoriteBook.id == book.id
                    }?.isFavorite = true
                }
                return@zipWith cacheBook
            })

        val netSingle = bookRepository.getBookList(param).zipWith(cacheFavoriteSingle,
            { netBook, cacheFavoriteBook ->
                cacheFavoriteBook.forEach { book ->
                    netBook.find { favoriteBook ->
                        favoriteBook.id == book.id
                    }?.isFavorite = true
                }
                return@zipWith netBook
            })

//        example for remote get and local save
//        val netSingle = bookRepository.getBookList(param)
//            .flatMap { bookRepository.saveListBook(it).andThen(cacheSingle) }

        return StatementSingle.ifThen(bookRepository.isConnected, netSingle, cacheSingle)
    }

}