package com.github.atsushi130.practice.exception

sealed class LoginException(override val code: Int, override val message: String): PracticeException(code, message) {
    class LoginFailure: LoginException(3000, "login failure.")
}