package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.UserDeviceRepositoryImpl
import com.github.atsushi130.practice.domain.repositories.UserDeviceRepository

data class UserDevice(val id: Int, val userId: String, val osVersion: OSVersion, val appVersion: AppVersion) {

    fun update() {
        UserDeviceRepositoryImpl.update(this)
    }

    companion object {
        private val repository: UserDeviceRepository = UserDeviceRepositoryImpl
        fun findBy(userId: String): UserDevice? = this.repository.findBy(userId)
    }
}