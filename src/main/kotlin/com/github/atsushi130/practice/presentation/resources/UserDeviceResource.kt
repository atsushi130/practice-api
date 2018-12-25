package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.exception.UserDeviceException
import java.io.Serializable

data class UserDeviceResource(val userId: String, val osType: String, val osVersion: String, val appVersion: String): Serializable {

    @Throws(UserDeviceException::class)
    fun toModel(): UserDevice {

        val osType = try {
            OS.valueOf(this.osType)
        } catch (throwable: Throwable) {
            throw UserDeviceException.InvalidOSType()
        }

        val appVersion = when (osType) {
            OS.iOS -> iOSAppVersion(this.appVersion)
            OS.Android -> AndroidAppVersion(this.appVersion)
        }
        return UserDevice(this.userId, OSVersion(this.osVersion), appVersion)
    }
}
