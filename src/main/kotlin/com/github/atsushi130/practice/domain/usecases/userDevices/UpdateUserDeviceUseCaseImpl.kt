package com.github.atsushi130.practice.domain.usecases.userDevices

import com.github.atsushi130.practice.domain.models.UserDevice
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class UpdateUserDeviceUseCaseImpl: UpdateUserDeviceUseCase {
    override fun execute(userDevice: UserDevice) = userDevice.update()
}