package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.presentation.presenters.UserDevicePresenter
import com.github.atsushi130.practice.presentation.resources.UserDeviceResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestScope
@Component
@Suppress("unused")
class UserDeviceController {

    @Autowired
    private lateinit var presenter: UserDevicePresenter

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = ["/sign_up"], method = [POST])
    fun updateUserDevice(@RequestBody userDevice: UserDeviceResource) = this.presenter.updateUserDevice(userDevice)
}
