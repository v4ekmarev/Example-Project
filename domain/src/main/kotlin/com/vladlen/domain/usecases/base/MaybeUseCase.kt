package com.vladlen.domain.usecases.base

import io.reactivex.Maybe


abstract class MaybeUseCase<R, in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?
) : UseCase<Maybe<R>, P>() {

    override fun execute(param: P): Maybe<R> =
        super.execute(param)
            .apply {
                useCaseScheduler?.let {
                    this.subscribeOn(it.run).observeOn(it.post)
                }
            }
}
