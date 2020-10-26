package com.vladlen.domain.usecases.base

import io.reactivex.Completable


abstract class CompletableUseCase<in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?,
) : UseCase<Completable, P>() {

    override fun execute(param: P): Completable =
        super.execute(param)
            .compose { transformer ->
                useCaseScheduler?.let {
                    transformer.subscribeOn(it.run).observeOn(it.post)
                } ?: transformer
            }
}
