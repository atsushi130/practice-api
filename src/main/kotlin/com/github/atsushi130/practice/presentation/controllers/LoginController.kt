package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.presentation.resources.LoginResource
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestScope
@Component
class LoginController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = [POST])
    fun login(@RequestBody loginResource: LoginResource) {
        println(loginResource)
    }
}