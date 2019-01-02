package com.github.atsushi130.practice.domain.usecases.userDevices

import com.github.atsushi130.practice.domain.models.UserDevice
import com.github.atsushi130.practice.domain.repositories.UserDeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class UpdateUserDeviceUseCaseImpl: UpdateUserDeviceUseCase {

    @Autowired
    private lateinit var repository: UserDeviceRepository

    override fun execute(userDevice: UserDevice) {
        this.repository.update(userDevice)
    }
}