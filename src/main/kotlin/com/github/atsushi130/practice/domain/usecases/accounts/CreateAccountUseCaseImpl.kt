package com.github.atsushi130.practice.domain.usecases.accounts

import com.github.atsushi130.practice.domain.models.Account
import org.springframework.stereotype.Service
import javax.security.auth.login.AccountException

@Service
@Suppress("unused")
class CreateAccountUseCaseImpl: CreateAccountUseCase {

    @Throws(AccountException::class)
    override fun execute(account: Account) {
        account.create()
    }
}