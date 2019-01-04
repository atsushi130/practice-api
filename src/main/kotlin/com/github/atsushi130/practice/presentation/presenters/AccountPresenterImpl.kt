package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.repositories.UserRepository
import com.github.atsushi130.practice.domain.usecases.accounts.CreateAccountUseCase
import com.github.atsushi130.practice.domain.usecases.sessions.CreateSessionUseCase
import com.github.atsushi130.practice.domain.usecases.userPasswords.AuthenticateUserPasswordUseCase
import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.SessionResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class AccountPresenter {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Autowired
    private lateinit var createSessionUseCase: CreateSessionUseCase

    @Autowired
    private lateinit var authenticateUserPasswordUseCase: AuthenticateUserPasswordUseCase

    @Throws(AccountException::class)
    fun signUp(account: AccountResource): SessionResource {
        val user = this.createAccountUseCase.execute(account.toModel())
        val session = this.createSessionUseCase.execute(user)
        return SessionResource.from(session)
    }

    fun signIn(account: AccountResource): SessionResource {
        if (this.authenticateUserPasswordUseCase.execute(account.toModel())) throw Exception()
        val session = this.userRepository.findBy(account.userId)
            ?.let { return@let this.createSessionUseCase.execute(it) }
            ?: throw Exception()
        return SessionResource.from(session)
    }
}