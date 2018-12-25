package com.github.atsushi130.practice.domain.usecases.userDevices

import com.github.atsushi130.practice.domain.models.UserDevice

interface UpdateUserDeviceUseCase {
    fun execute(userDevice: UserDevice)
}