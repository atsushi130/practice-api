package com.github.atsushi130.practice.domain.usecases.sessions

import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.SessionRepository
import com.github.atsushi130.practice.exception.LoginException
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
@Suppress("unused")
class CreateSessionUseCaseImpl: CreateSessionUseCase {

    @Autowired
    private lateinit var repository: SessionRepository

    @Throws(LoginException::class)
    override fun execute(user: User): Session {
        val sessionId = UUID.randomUUID().toString()
        return transaction {
            return@transaction repository.create(sessionId, user)
        }
    }
}