package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.tables.Sessions
import com.github.atsushi130.practice.data.entities.SessionEntity
import com.github.atsushi130.practice.data.entities.UserEntity
import com.github.atsushi130.practice.data.tables.Users
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository

@Repository
@Suppress("unused")
class SessionRepositoryImpl: SessionRepository {

    override fun findBySessionId(id: String): Session? {
        return transaction {
            SessionEntity
                .find { Sessions.id eq id }
                .singleOrNull()
                ?.toModel()
        }
    }

    override fun findByUserId(userId: String): Session? {
        return transaction {
            SessionEntity
                .find { Sessions.userId eq userId }
                .singleOrNull()
                ?.toModel()
        }
    }

    override fun create(id: String, user: User): Session {
        return transaction {
            Sessions
                .insert {
                    it[Sessions.id] = EntityID(id, Sessions)
                    it[Sessions.userId] = EntityID(user.id, Users)
                }
            SessionEntity
                .find { Sessions.userId eq user.id }
                .single()
                .toModel()
        }
    }
}