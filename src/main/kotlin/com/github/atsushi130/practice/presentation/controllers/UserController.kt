package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.presentation.presenters.UserPresenter
import com.github.atsushi130.practice.presentation.resources.UserResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestScope
@Component
class UserController {

    @Autowired
    private lateinit var presenter: UserPresenter

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/item_funs/{itemId}", method = [GET])
    fun getFuns(@PathVariable("itemId") itemId: String): List<UserResource> = this.presenter.getFunsBy(itemId)
}