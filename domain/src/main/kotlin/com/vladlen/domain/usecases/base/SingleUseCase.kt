package com.vladlen.domain.usecases.base

import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<R, in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?,
) : UseCase<Single<R>, P>() {

    override fun execute(param: P): Single<R> =
            super.execute(param)
                    .apply {
                        useCaseScheduler?.let {
                            this.subscribeOn(it.run).observeOn(it.post)
                        }
                    }
}
