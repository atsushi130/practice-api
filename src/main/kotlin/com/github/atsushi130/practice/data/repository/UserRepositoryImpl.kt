package com.github.atsushi130.practice.data.repository

import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repository.UserRepository

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