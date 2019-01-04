package com.github.atsushi130.practice.domain.usecases.login

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Session
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.exception.LoginException

interface LoginUseCase {
    @Throws(LoginException::class)
    fun execute(user: User): Session
}