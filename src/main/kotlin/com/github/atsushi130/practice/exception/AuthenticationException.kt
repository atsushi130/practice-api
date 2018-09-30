package com.github.atsushi130.practice.exception

sealed class AuthenticationException(override val code: Int, override val message: String): PracticeException(code, message) {
    class AuthenticationHeaderNotExists: AuthenticationException(1000, "authentication header does not exists.")
    class BearTokenNotExists: AuthenticationException(1001, "bearer token does not exists.")
    class CookieNotExists: AuthenticationException(1002, "cookie does not exists.")
    class SessionIdNotExists: AuthenticationException(1003, "sessionId does not exists.")
    class InvalidSessionId: AuthenticationException(1004, "invalid sessionId.")
}