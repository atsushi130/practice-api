package com.github.atsushi130.practice.domain.usecases.login

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Session

interface LoginUseCase {
    fun execute(account: Account): Session
}