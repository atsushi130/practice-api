package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.SessionRepositoryImpl

/**
 * primary key: sessionId
 * session has one user
 */
data class Session( val id: String, val userId: String) {

    val user: User
       get() = User.findBy(this.userId)!!

    companion object {

        private val repository = SessionRepositoryImpl

        fun findBySessionId(id: String): Session? = this.repository.findBy(id)

        fun findByUserId(id: String): Session? = this.repository.findBy(id)

        fun exists(sessionId: String): Boolean {
            // session find by sessionId from session store.
            // return true if session exists.
            return true
        }
    }
}