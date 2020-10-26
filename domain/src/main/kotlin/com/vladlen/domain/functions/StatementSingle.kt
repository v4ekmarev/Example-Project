package com.vladlen.domain.functions

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.plugins.RxJavaPlugins

/**
 * Imperative statements expressed as Single operators.
 * inspiration from https://github.com/akarnokd/RxJava2Extensions
 */
object StatementSingle {

    /**
     * Return an Single that emits the emissions from one specified
     * Single if a condition evaluates to true, or from another specified
     * Single otherwise.
     *
     * @param <R> the result value type
     * @param condition the condition that decides which Observable to emit the emissions from
     * @param then the Single sequence to emit to if `condition` is `true`
     * @param orElse the Single sequence to emit to if `condition` is `false`
     * @return an Single that mimics either the `then` or `orElse` Single depending on a condition function
     */
    fun <R> ifThen(
        condition: Boolean,
        then: SingleSource<out R>,
        orElse: Single<out R>
    ): Single<R> =
        RxJavaPlugins.onAssembly(SingleIfThen(condition, then, orElse))

}
