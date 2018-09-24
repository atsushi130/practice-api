package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Account
import java.io.Serializable

data class AccountResource(val userId: String, val password: String): Serializable {
    fun toModel(): Account {
        return Account(this.userId, this.password)
    }
}
