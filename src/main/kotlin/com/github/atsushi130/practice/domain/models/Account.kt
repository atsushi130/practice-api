package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.exception.AccountException

data class Account(val userId: String, val password: String) {

    @Throws(AccountException::class)
    fun create() {
        this.validate()
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