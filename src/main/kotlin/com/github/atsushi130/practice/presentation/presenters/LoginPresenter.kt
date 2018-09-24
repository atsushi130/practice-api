package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.domain.usecases.accounts.CreateAccountUseCase
import com.github.atsushi130.practice.domain.usecases.login.LoginUseCase
import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.LoginResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LoginPresenter {

    @Autowired
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Autowired
    private lateinit var loginUseCase: LoginUseCase

    @Throws(AccountException::class)
    fun signUp(account: AccountResource): LoginResource {
        this.createAccountUseCase.execute(account.toModel())
        val session = this.loginUseCase.execute(account.toModel())
        return LoginResource.from(session)
    }

    fun signIn(account: AccountResource): LoginResource {
        val session = this.loginUseCase.execute(account.toModel())
        return LoginResource.from(session)
    }
}