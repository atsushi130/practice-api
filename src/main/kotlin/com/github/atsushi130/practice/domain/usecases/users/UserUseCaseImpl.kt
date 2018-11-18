package com.github.atsushi130.practice.domain.usecases.users

import com.github.atsushi130.practice.domain.models.User
import org.springframework.stereotype.Service

@Service
class UserUseCaseImpl: UserUseCase {
    override fun findFunsBy(itemId: String): List<User> = User.findFunsBy(itemId)
}
