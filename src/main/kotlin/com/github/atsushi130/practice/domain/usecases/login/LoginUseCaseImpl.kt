package com.github.atsushi130.practice.domain.usecases.login

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import com.github.atsushi130.practice.exception.LoginException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class LoginUseCaseImpl: LoginUseCase {

    @Autowired
    private lateinit var repository: SessionRepository

    @Throws(LoginException::class)
    override fun execute(account: Account): Session {
        return this.repository.findByUserId(account.userId) ?: throw LoginException.LoginFailure()
    }
}