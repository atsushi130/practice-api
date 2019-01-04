package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.tables.UserPasswords
import com.github.atsushi130.practice.domain.models.Account
import org.jetbrains.exposed.sql.ResultRow

data class UserPasswordEntity(val userId: String, val password: String) {

    fun toAccount(): Account {
        return Account(this.userId, this.password)
    }

    companion object {
        fun from(row: ResultRow): UserPasswordEntity {
            return UserPasswordEntity(row[UserPasswords.userId], row[UserPasswords.password])
        }
    }
}
