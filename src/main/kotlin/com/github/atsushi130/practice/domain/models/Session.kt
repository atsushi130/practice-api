package com.github.atsushi130.practice.domain.models

/**
 * primary key: sessionId
 * session has one user
 */
data class Session(val sessionId: String, val userId: String) {

    val user: User
       get() = User(this.userId)

    companion object {

        fun findBy(sessionId: String): Session? {
            return Session(sessionId, "1")
        }

        fun exists(sessionId: String): Boolean {
            // session find by sessionId from session store.
            // return true if session exists.
            return true
        }
    }
}