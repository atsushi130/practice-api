package com.github.atsushi130.practice.domain.usecases.accounts

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.models.UserDevice
import com.github.atsushi130.practice.domain.repositories.UserDeviceRepository
import com.github.atsushi130.practice.domain.repositories.UserPasswordRepository
import com.github.atsushi130.practice.domain.repositories.UserRepository
import com.github.atsushi130.practice.domain.shared.DeviceContainer
import com.github.atsushi130.practice.domain.shared.UserContainer
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.security.auth.login.AccountException

@Service
@Suppress("unused")
class CreateAccountUseCaseImpl: CreateAccountUseCase {

    @Autowired
    private lateinit var userPasswordRepository: UserPasswordRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userDeviceRepository: UserDeviceRepository

    @Autowired
    private lateinit var userContainer: UserContainer

    @Autowired
    private lateinit var deviceContainer: DeviceContainer

    @Throws(AccountException::class)
    override fun execute(account: Account): User {
        val validatedAccount = account.validate()
        return transaction {
            userPasswordRepository.create(validatedAccount)
            val user = userRepository.create(account.userId)
            userDeviceRepository.create(user.id, deviceContainer.device)
            return@transaction user
        }
    }
}