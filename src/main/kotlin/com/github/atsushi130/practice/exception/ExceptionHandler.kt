package com.github.atsushi130.practice.exception

import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class ExceptionHandler {

    @AfterThrowing("execution(* com.github.atsushi130.practice.domain..*(..))", throwing = "exception")
    @Throws(PracticeException::class)
    fun afterThrowing(exception: PracticeException) {
        // logging
    }


    @AfterThrowing("execution(* com.github.atsushi130.practice.domain..*(..))", throwing = "exception")
    @Throws(Exception::class)
    fun afterThrowing(exception: Exception) {
        // logging
    }
}