package com.example.flow.utils

sealed class DataState <out T: Any, out U: Any> {

    data class Success<T: Any>(val data: T): DataState<T, Nothing>()
    data class Error<U: Any>(val error: U): DataState<Nothing, U>()
    object Loading : DataState<Nothing, Nothing>()
    object Finished: DataState<Nothing, Nothing>()
}
