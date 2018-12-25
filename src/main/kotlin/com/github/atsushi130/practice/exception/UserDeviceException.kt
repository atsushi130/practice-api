package com.github.atsushi130.practice.exception

sealed class UserDeviceException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class InvalidOSType: UserDeviceException(ExceptionCode.UserDevice(0), "invalid os type.")
}