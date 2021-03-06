package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.exception.PracticeException
import java.io.Serializable
import java.lang.Exception

data class ErrorResource(val code: Int, val message: String): Serializable {
    companion object {

        fun from(exception: PracticeException): ErrorResource = ErrorResource(exception.code.value, exception.message)

        fun from(exception: Exception): ErrorResource = ErrorResource(0, exception.message ?: "")
    }
}