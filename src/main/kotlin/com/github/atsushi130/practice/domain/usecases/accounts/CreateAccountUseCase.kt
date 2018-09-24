package com.github.atsushi130.practice.domain.usecases.accounts

import com.github.atsushi130.practice.domain.models.Account

interface CreateAccountUseCase {
    fun execute(account: Account)
}