package com.github.atsushi130.practice.exception

sealed class AuthenticationException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class CookieNotExists: AuthenticationException(ExceptionCode.Authentication(0), "cookie does not exists.")
    class SessionIdNotExists: AuthenticationException(ExceptionCode.Authentication(1), "sessionId does not exists.")
    class InvalidSessionId: AuthenticationException(ExceptionCode.Authentication(2), "invalid sessionId.")
}