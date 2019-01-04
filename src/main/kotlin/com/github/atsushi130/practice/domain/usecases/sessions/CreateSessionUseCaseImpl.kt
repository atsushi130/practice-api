package com.github.atsushi130.practice.domain.usecases.login

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import com.github.atsushi130.practice.exception.LoginException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class LoginUseCaseImpl: CreateSessionUseCase {

    @Autowired
    private lateinit var repository: SessionRepository

    @Throws(LoginException::class)
    override fun execute(user: User): Session {
        return this.repository.findByUserId(user.id) ?: throw LoginException.LoginFailure()
    }
}