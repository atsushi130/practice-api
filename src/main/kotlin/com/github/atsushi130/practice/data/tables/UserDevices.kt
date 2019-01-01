package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.dao.IntIdTable


object UserDevices: IntIdTable("user_devices") {
    val osType = varchar("os_type", 16)
    val osVersion = varchar("os_version", 16)
    val appVersion = varchar("app_version", 16)
    val userId = varchar("user_id", 36)
}
