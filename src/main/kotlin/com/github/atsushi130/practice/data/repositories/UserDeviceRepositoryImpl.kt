package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.entities.UserDeviceEntity
import com.github.atsushi130.practice.data.tables.UserDevices
import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.domain.repositories.UserDeviceRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
@Suppress("unused")
class UserDeviceRepositoryImpl: UserDeviceRepository {

    override fun findBy(userId: String): List<UserDevice> {
        return transaction {
            UserDeviceEntity
                .find { UserDevices.userId eq userId }
                .map { it.toModel() }
        }
    }

    override fun update(userDevice: UserDevice) {
    }

    override fun create(userId: String, device: Device): UserDevice {
        return transaction {
            UserDeviceEntity
                .new {
                    this.userId = userId
                    this.osType = device.osType.name
                    this.osVersion = device.osVersion.version
                    this.appVersion = device.appVersion.version
                }
                .toModel()
        }
    }
}
