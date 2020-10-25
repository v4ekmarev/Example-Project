package com.vladlen.domain.usecases.base

abstract class UseCase<R, in P> {

    protected abstract fun build(param: P): R

    protected open fun execute(param: P): R {
        return build(param)
    }

}