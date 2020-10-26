package com.vladlen.domain.usecases.base

import io.reactivex.Flowable


abstract class FlowableUseCase<R, in P>
constructor(
    private val useCaseScheduler: UseCaseScheduler?,
) : UseCase<Flowable<R>, P>() {

    override fun execute(param: P): Flowable<R> =
        super.execute(param)
            .compose { transformer ->
                useCaseScheduler?.let {
                    transformer.subscribeOn(it.run).observeOn(it.post)
                } ?: transformer
            }

}
