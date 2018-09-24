package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.UserRepository

class UserRepositoryImpl {
    companion object: UserRepository {
        override fun findBy(id: String): User? {
            if (id == "F2940B42-20AC-4F74-918F-479FCD547FF5") {
                return User(id)
            }
            return null
        }
    }
}