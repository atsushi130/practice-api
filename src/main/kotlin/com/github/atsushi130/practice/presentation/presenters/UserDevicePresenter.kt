package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.presentation.resources.UserDeviceResource

interface UserDevicePresenter {
    fun updateUserDevice(userDevice: UserDeviceResource)
}