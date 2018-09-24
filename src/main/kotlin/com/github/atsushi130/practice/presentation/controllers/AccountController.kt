package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.presenters.AccountPresenter
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.ErrorResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.POST
import java.lang.Exception

@RestController
@RequestScope
@Component
class AccountController {

    @Autowired
    private lateinit var presenter: AccountPresenter

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/account/create", method = [POST])
    fun create(@RequestBody account: AccountResource) = this.presenter.create(account)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(exception: Exception): ErrorResource = ErrorResource.from(exception)

    @ExceptionHandler(AccountException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(exception: AccountException): ErrorResource = ErrorResource.from(exception)
}