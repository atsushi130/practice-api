package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.usecases.accounts.CreateAccountUseCase
import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.resources.AccountResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AccountPresenter {

    @Autowired
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Throws(AccountException::class)
    fun signUp(account: AccountResource) {
        val model = account.toModel()
        this.createAccountUseCase.execute(model)
    }
}