package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.domain.repositories.UserDeviceRepository

/**
 * Schema
 * userId: Int
 * osType: String
 * osVersion: String
 * appVersion: String
 */
class UserDeviceRepositoryImpl {
    companion object: UserDeviceRepository {

        override fun findBy(userId: String): UserDevice? {
            val osVersion = OSVersion("12.0.0")
            val appVersion = iOSAppVersion("1.0.0")
            return UserDevice(1, userId, osVersion, appVersion)
        }

        override fun update(userDevice: UserDevice) {
        }
    }
}
