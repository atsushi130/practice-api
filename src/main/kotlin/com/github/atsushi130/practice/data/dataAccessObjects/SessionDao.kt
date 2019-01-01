package com.github.atsushi130.practice.data.dataAccessObjects

import com.github.atsushi130.practice.data.tables.SessionEntity
import com.github.atsushi130.practice.data.tables.Sessions
import org.springframework.stereotype.Component

@Component
class SessionDao {

    fun findBySessionId(id: String): SessionEntity? {
        return SessionEntity
            .find { Sessions.id eq id }
            .firstOrNull()
    }

    fun findByUserId(userId: String): SessionEntity? {
        return SessionEntity
            .find { Sessions.userId eq userId }
            .firstOrNull()
    }
}