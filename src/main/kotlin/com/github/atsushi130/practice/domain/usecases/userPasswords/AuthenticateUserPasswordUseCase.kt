package com.github.atsushi130.practice.domain.usecases.userPasswords

import com.github.atsushi130.practice.domain.models.Account

interface AuthenticateUserPasswordUseCase {
    fun execute(account: Account): Boolean
}