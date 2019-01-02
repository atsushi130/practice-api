package com.github.atsushi130.practice.controllerAdviser

import com.github.atsushi130.practice.exception.AuthenticationException
import com.github.atsushi130.practice.exception.UserStateException
import com.github.atsushi130.practice.presentation.resources.ErrorResource
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Suppress("unused")
class ExceptionHandlerControllerAdviser {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST /* 400 */)
    fun badRequest(exception: Exception) = ErrorResource.from(exception)

    @ExceptionHandler(AuthenticationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED /* 401 */)
    fun unauthorized(exception: AuthenticationException) = ErrorResource.from(exception)

    @ExceptionHandler(UserStateException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN /* 403 */)
    fun forbidden(exception: UserStateException) = ErrorResource.from(exception)
}