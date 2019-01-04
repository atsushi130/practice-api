package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.repositories.UserRepository
import com.github.atsushi130.practice.domain.usecases.accounts.CreateAccountUseCase
import com.github.atsushi130.practice.domain.usecases.sessions.CreateSessionUseCase
import com.github.atsushi130.practice.domain.usecases.userPasswords.AuthenticateUserPasswordUseCase
import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.SessionResource
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class AccountPresenterImpl: AccountPresenter {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Autowired
    private lateinit var createSessionUseCase: CreateSessionUseCase

    @Autowired
    private lateinit var authenticateUserPasswordUseCase: AuthenticateUserPasswordUseCase

    @Throws(AccountException::class)
    override fun signUp(account: AccountResource): SessionResource {
        return transaction {
            val user = createAccountUseCase.execute(account.toModel())
            val session = createSessionUseCase.execute(user)
            return@transaction SessionResource.from(session)
        }
    }

    @Throws(AccountException::class)
    override fun signIn(account: AccountResource): SessionResource {
        if (this.authenticateUserPasswordUseCase.execute(account.toModel())) throw Exception()
        return transaction {
            val session = userRepository.findBy(account.userId)
                ?.let { return@let createSessionUseCase.execute(it) }
                ?: throw Exception()
            return@transaction SessionResource.from(session)
        }
    }
}