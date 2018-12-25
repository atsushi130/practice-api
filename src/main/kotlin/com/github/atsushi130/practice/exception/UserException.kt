package com.github.atsushi130.practice.exception

sealed class UserException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class UserDeviceNotExists: UserException(ExceptionCode.User(0), "not found user device.")
}
