package com.vladlen.domain.usecases.base

import io.reactivex.Single


abstract class SingleUseCase<R, in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?,
) : UseCase<Single<R>, P>() {

    override fun execute(param: P): Single<R> =
        super.execute(param)
            .compose { transformer ->
                useCaseScheduler?.let {
                    transformer.subscribeOn(it.run).observeOn(it.post)
                } ?: transformer
            }
}
