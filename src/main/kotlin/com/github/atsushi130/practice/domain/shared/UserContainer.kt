package com.github.atsushi130.practice.domain.shared

import com.github.atsushi130.practice.domain.models.User
import org.springframework.stereotype.Component

@Component
class UserContainer {

    // MEMO: want to change private set, but can not modify final.
    val user: User
        get() = this.authenticatedUser

    private lateinit var authenticatedUser: User

    fun setAuthenticatedUser(user: User) {
        this.authenticatedUser = user
    }
}