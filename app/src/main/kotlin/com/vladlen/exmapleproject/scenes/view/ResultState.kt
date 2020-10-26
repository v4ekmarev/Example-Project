package com.vladlen.exmapleproject.scenes.view

sealed class ResultState<out R> {

    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val exception: Throwable?) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [ResultState] is of type [Success] & holds non-null [Success.data].
 */
val ResultState<*>.succeeded
    get() = this is ResultState.Success && data != null
