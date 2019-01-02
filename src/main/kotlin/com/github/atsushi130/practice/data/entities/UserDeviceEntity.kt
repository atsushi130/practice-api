package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.tables.UserDevices
import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.exception.UserDeviceException
import com.github.atsushi130.practice.extension.findBy
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class UserDeviceEntity(id: EntityID<Int>): IntEntity(id) {

    companion object : IntEntityClass<UserDeviceEntity>(UserDevices)

    private val userId by UserDevices.userId
    private val osType by UserDevices.osType
    private val osVersion by UserDevices.osVersion
    private val appVersion by UserDevices.appVersion

    @Throws(UserDeviceException.InvalidOSType::class)
    fun toModel(): UserDevice {
        val osType = OS.findBy(this.osType) ?: throw UserDeviceException.InvalidOSType()
        val osVersion = OSVersion(this.osVersion)
        val appVersion = when (osType) {
            OS.iOS -> iOSAppVersion(this.appVersion)
            OS.Android -> AndroidAppVersion(this.appVersion)
        }
        return UserDevice(this.id.value, this.userId, osVersion, appVersion)
    }
}