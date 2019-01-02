package com.github.atsushi130.practice.domain.usecases.users

import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class UserUseCaseImpl: UserUseCase {

    @Autowired
    private lateinit var repository: UserRepository

    override fun findFunsBy(itemId: Int): List<User> = this.repository.findFunsBy(itemId)
}
