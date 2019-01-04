package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Device
import com.github.atsushi130.practice.domain.models.UserDevice

interface UserDeviceRepository {
    fun findBy(userId: String): List<UserDevice>
    fun update(userDevice: UserDevice)
    fun create(userId: String, device: Device): UserDevice
}