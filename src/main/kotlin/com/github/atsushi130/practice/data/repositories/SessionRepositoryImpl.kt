package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.dataAccessObjects.SessionDao
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class SessionRepositoryImpl: SessionRepository {

    @Autowired
    private lateinit var dao: SessionDao

    override fun findBySessionId(id: String): Session? {
        return this.dao.findBySessionId(id)?.toModel()
    }

    override fun findByUserId(userId: String): Session? {
        return this.dao.findByUserId(userId)?.toModel()
    }
}