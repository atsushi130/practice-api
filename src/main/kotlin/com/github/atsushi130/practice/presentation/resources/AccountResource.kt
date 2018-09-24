package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.exception.AccountException
import java.io.Serializable

data class AccountResource(val account: String, val password: String): Serializable {

    @Throws(AccountException::class)
    fun toModel(): Account {
        this.validate()
        return Account(this.account, this.password)
    }

    @Throws(AccountException::class)
    fun validate() {
        this.validateAccount()
        this.validatePassword()
    }

    @Throws(AccountException.AccountRuleNotEnough::class)
    private fun validateAccount() {}

    @Throws(AccountException.PasswordRuleNotEnough::class)
    private fun validatePassword() {
        if (password.length !in 6..18) {
            throw AccountException.PasswordRuleNotEnough()
        }
    }
}
