package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Account

interface UserPasswordRepository {
    fun create(account: Account)
    fun findBy(userId: String): Account?
}