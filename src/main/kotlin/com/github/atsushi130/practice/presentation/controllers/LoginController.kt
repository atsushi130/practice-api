package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.presenters.AccountPresenter
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.ErrorResource
import com.github.atsushi130.practice.presentation.resources.SessionResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestScope
@Component
@Suppress("unused")
class LoginController {

    @Autowired
    private lateinit var presenter: AccountPresenter

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = ["/sign_up"], method = [POST])
    fun signUp(@RequestBody account: AccountResource): SessionResource = this.presenter.signUp(account)

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = ["/sign_in"], method = [POST])
    fun signIn(@RequestBody account: AccountResource): SessionResource = this.presenter.signIn(account)

    @ExceptionHandler(AccountException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(exception: AccountException): ErrorResource = ErrorResource.from(exception)
}