package com.vladlen.domain.usecases

import com.vladlen.domain.model.Book
import com.vladlen.domain.repository.BookRepository
import com.vladlen.domain.usecases.base.CompletableUseCase
import com.vladlen.domain.usecases.base.FlowableUseCase
import com.vladlen.domain.usecases.base.UseCaseScheduler
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class SaveFavoriteBookUseCase
@Inject internal constructor(
    private val bookRepository: BookRepository,
    useCaseScheduler: UseCaseScheduler? = null
) : CompletableUseCase<Book>(useCaseScheduler) {

    override fun build(param: Book): Completable {
        return bookRepository.saveFavoriteBook(param)
    }
}
