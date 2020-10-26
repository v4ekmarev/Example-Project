package com.vladlen.domain.usecases

import com.vladlen.domain.model.Book
import com.vladlen.domain.repository.BookRepository
import com.vladlen.domain.usecases.base.FlowableUseCase
import com.vladlen.domain.usecases.base.UseCaseScheduler
import io.reactivex.Flowable
import javax.inject.Inject

class GetFavoriteBookUseCase
@Inject internal constructor(
    private val bookRepository: BookRepository,
    useCaseScheduler: UseCaseScheduler? = null
) : FlowableUseCase<List<Book>, Boolean>(useCaseScheduler) {

    override fun build(param: Boolean): Flowable<List<Book>> {
        return bookRepository.getCashedFavoriteListBook(param)
    }
}
