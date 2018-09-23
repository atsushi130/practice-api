package com.github.atsushi130.practice.domain.repository

import com.github.atsushi130.practice.domain.models.User

interface UserRepository {
    fun findBy(id: String): User?
}