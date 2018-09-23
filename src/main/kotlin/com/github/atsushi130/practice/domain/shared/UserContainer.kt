package com.github.atsushi130.practice.domain.shared

import com.github.atsushi130.practice.domain.models.User
import org.springframework.stereotype.Component

@Component
class UserContainer {

    final lateinit var user: User private set

    fun setAuthenticatedUser(user: User) {
        this.user = user
    }
}