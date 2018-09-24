package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.exception.PracticeException
import java.lang.Exception

data class ErrorResource(val code: Int, val message: String) {
    companion object {

        fun from(exception: PracticeException): ErrorResource = ErrorResource(exception.code, exception.message)

        fun from(exception: Exception): ErrorResource = ErrorResource(0, exception.message ?: "")
    }
}