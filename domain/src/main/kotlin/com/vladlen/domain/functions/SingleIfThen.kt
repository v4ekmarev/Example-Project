package com.vladlen.domain.functions

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleSource


class SingleIfThen<T>(
    private val condition: Boolean,
    private val then: SingleSource<out T>,
    private val orElse: SingleSource<out T>
) : Single<T>() {

    override fun subscribeActual(observer: SingleObserver<in T>) {
        if (condition) {
            then.subscribe(observer)
        } else {
            orElse.subscribe(observer)
        }
    }
}

