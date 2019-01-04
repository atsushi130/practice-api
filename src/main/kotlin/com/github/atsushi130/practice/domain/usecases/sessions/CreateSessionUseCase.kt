package com.github.atsushi130.practice.domain.usecases.sessions

import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.exception.LoginException

interface CreateSessionUseCase {
    @Throws(LoginException::class)
    fun execute(user: User): Session
}