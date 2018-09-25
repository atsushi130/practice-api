package com.github.atsushi130.practice.domain.usecases.login

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.exception.LoginException
import org.springframework.stereotype.Service

@Service
class LoginUseCaseImpl: LoginUseCase {

    @Throws(LoginException::class)
    override fun execute(account: Account): Session {
        return Session.findByUserId(account.userId) ?: throw LoginException.LoginFailure()
    }
}