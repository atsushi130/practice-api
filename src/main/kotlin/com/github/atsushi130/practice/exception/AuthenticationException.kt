package com.github.atsushi130.practice.exception

sealed class AuthenticationException(override val code: Int, override val message: String): PracticeException(code, message) {
    class CookieNotExists: AuthenticationException(1000, "cookie does not exists.")
    class SessionIdNotExists: AuthenticationException(1001, "sessionId does not exists.")
    class InvalidSessionId: AuthenticationException(1002, "invalid sessionId.")
}