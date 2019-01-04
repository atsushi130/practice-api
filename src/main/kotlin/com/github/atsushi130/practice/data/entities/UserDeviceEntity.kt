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

    var userId by UserDevices.userId
    var osType by UserDevices.osType
    var osVersion by UserDevices.osVersion
    var appVersion by UserDevices.appVersion

    @Throws(UserDeviceException.InvalidOSType::class)
    fun toModel(): UserDevice {
        val osType = OS.findBy(this.osType) ?: throw UserDeviceException.InvalidOSType()
        val osVersion = OSVersion(this.osVersion)
        val appVersion = when (osType) {
            OS.iOS -> iOSAppVersion(this.appVersion)
            OS.Android -> AndroidAppVersion(this.appVersion)
        }
        val device = Device(osType, osVersion, appVersion)
        return UserDevice(this.id.value, this.userId, device)
    }
}