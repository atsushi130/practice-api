package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.models.Validated

interface UserPasswordRepository {
    fun create(account: Validated<Account>)
    fun findBy(userId: String): Account?
}