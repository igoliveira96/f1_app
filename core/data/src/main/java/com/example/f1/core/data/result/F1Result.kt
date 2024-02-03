@file:Suppress("UNCHECKED_CAST", "RedundantVisibilityModifier")

package com.example.f1.core.data.result

class F1Result<out T> @PublishedApi internal constructor(
    @PublishedApi
    internal val value: Any?
) {

    val isSuccess: Boolean get() = value !is Failure

    val isFailure: Boolean get() = value is Failure

    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    fun exceptionOrNull(): Throwable? =
        when (value) {
            is Failure -> value.exception
            else -> null
        }

    override fun toString(): String =
        when (value) {
            is Failure -> value.toString()
            else -> "Success($value)"
        }

    companion object {
        fun <T> success(value: T): F1Result<T> =
            F1Result(value)

        fun <T> failure(exception: Throwable): F1Result<T> =
            F1Result(createFailure(exception))
    }

    internal class Failure(
        @JvmField
        val exception: Throwable
    ) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }

}

@PublishedApi
internal fun createFailure(exception: Throwable): Any =
    F1Result.Failure(exception)
