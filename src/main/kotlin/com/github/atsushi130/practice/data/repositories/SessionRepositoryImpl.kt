package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.tables.SessionEntity
import com.github.atsushi130.practice.data.tables.Sessions
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import org.springframework.stereotype.Repository

@Repository
class SessionRepositoryImpl: SessionRepository {

    override fun findBySessionId(id: String): Session? {
        return SessionEntity
            .find { Sessions.id eq id }
            .firstOrNull()
            ?.toModel()
    }

    override fun findByUserId(userId: String): Session? {
        return SessionEntity
            .find { Sessions.userId eq userId }
            .firstOrNull()
            ?.toModel()
    }
}