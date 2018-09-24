package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.repositories.SessionRepository

class SessionRepositoryImpl {
    companion object: SessionRepository {
        override fun findBySessionId(id: String): Session? {
            if (id == "5755BECA-1A85-4714-AF0C-4ECE06E5BE16") {
                return Session(id, "atsushi130")
            }
            return null
        }

        override fun findByUserId(id: String): Session? {
            if (id == "atsushi130") {
                return Session("5755BECA-1A85-4714-AF0C-4ECE06E5BE16", id)
            }
            return null
        }
    }
}