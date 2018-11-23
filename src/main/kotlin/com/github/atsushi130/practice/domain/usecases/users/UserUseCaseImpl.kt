package com.github.atsushi130.practice.domain.usecases.users

import com.github.atsushi130.practice.domain.models.User
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class UserUseCaseImpl: UserUseCase {
    override fun findFunsBy(itemId: String): List<User> = User.findFunsBy(itemId)
}
