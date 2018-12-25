package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.domain.usecases.userDevices.UpdateUserDeviceUseCase
import com.github.atsushi130.practice.presentation.resources.UserDeviceResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class UserDevicePresenterImpl: UserDevicePresenter {

    @Autowired
    private lateinit var userContainer: UserContainer

    @Autowired
    private lateinit var useCase: UpdateUserDeviceUseCase

    override fun updateUserDevice(userDevice: UserDeviceResource) = this.useCase.execute(userDevice.toModel())
}
