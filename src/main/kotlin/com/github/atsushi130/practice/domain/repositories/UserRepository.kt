package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.User

interface UserRepository {
    fun findBy(id: String): User?
    fun findFunsBy(itemId: Int): List<User>
    fun create(id: String): User
}