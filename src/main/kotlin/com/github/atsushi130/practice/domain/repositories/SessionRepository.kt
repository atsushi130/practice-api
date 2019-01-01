package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Session

interface SessionRepository {
    fun findBySessionId(id: String): Session?
    fun findByUserId(userId: String): Session?
}