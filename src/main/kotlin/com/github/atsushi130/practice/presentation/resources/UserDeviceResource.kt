package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.exception.UserDeviceException
import java.io.Serializable

data class UserDeviceResource(val id: Int, val userId: String, val osType: String, val osVersion: String, val appVersion: String): Serializable {

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

        val device = Device(osType, OSVersion(this.osVersion), appVersion)
        return UserDevice(this.id, this.userId, device)
    }
}
