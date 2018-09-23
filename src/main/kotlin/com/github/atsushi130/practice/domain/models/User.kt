package com.github.atsushi130.practice.domain.models

data class User(val id: String) {
    companion object {
        fun findBy(sessionId: String): User {
            return User("1")
        }
    }
}