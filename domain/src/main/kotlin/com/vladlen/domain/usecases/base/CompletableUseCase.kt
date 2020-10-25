package com.vladlen.domain.usecases.base

import io.reactivex.rxjava3.core.Completable

abstract class CompletableUseCase<in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?,
) : UseCase<Completable, P>() {

    override fun execute(param: P): Completable =
            super.execute(param)
                    .apply {
                        useCaseScheduler?.let {
                            this.subscribeOn(it.run).observeOn(it.post)
                        }
                    }
}
