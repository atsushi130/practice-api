package com.github.atsushi130.practice.exception

sealed class LoginException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class LoginFailure: LoginException(ExceptionCode.Login(0), "login failure.")
}