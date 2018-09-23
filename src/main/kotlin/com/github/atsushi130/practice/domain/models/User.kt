package com.github.atsushi130.practice.domain.models

data class User(val id: String) {
    companion object {
        fun findBy(id: String): User {
            return User("1")
        }
    }
}