package com.github.atsushi130.practice.exception

sealed class UserStateException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class Banned: UserStateException(ExceptionCode.UserState(0), "banned user.")
    class DoesNotMeetsRequiredVersion: UserStateException(ExceptionCode.UserState(1), "does not meets required app version.")
}
