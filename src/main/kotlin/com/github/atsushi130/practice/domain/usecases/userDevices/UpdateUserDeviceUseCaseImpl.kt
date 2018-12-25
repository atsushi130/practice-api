package com.github.atsushi130.practice.domain.usecases.userDevices

import com.github.atsushi130.practice.domain.models.UserDevice

class UpdateUserDeviceUseCaseImpl: UpdateUserDeviceUseCase {
    override fun execute(userDevice: UserDevice) = userDevice.update()
}