package com.github.atsushi130.practice.domain.usecases.userPasswords

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.repositories.UserPasswordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticateUserPasswordUseCaseImpl: AuthenticateUserPasswordUseCase {

    @Autowired
    private lateinit var userPasswordRepository: UserPasswordRepository

    override fun execute(account: Account): Boolean {
        val account = this.userPasswordRepository.findBy(account.userId)
        return account == account
    }
}
