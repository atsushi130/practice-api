package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User

interface SessionRepository {
    fun findBySessionId(id: String): Session?
    fun findByUserId(userId: String): Session?
    fun create(id: String, user: User): Session
}