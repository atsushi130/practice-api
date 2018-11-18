package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.UserRepository
import java.util.*

class UserRepositoryImpl {
    companion object: UserRepository {

        override fun findBy(id: String): User? {
            if (id == "atsushi130") {
                return User(id)
            }
            return null
        }

        override fun findFunsBy(itemId: String): List<User> = Arrays.asList()
    }
}