package com.github.atsushi130.practice.domain.usecases.accounts

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.User
import javax.security.auth.login.AccountException

interface CreateAccountUseCase {
    @Throws(AccountException::class)
    fun execute(account: Account): User
}