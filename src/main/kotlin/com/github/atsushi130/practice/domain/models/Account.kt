package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.extension.alphabets

data class Account(val userId: String, val password: String) {

    @Throws(AccountException::class)
    fun validate() {
        this.validateAccount()
        this.validatePassword()
    }

    @Throws(AccountException.AccountRuleNotEnough::class)
    private fun validateAccount() {
        if (this.userId.length !in 1..36) throw AccountException.AccountRuleNotEnough.InvalidLength()
        val validCharacters = Account.validCharacters + String.alphabets
        val isValid = this.userId
            .map { it.toString() }
            .fold(true) { sum, character ->
                sum && validCharacters.contains(character)
            }
        if (!isValid) throw AccountException.AccountRuleNotEnough.InvalidCharacter()
    }

    @Throws(AccountException.PasswordRuleNotEnough::class)
    private fun validatePassword() {
        if (password.length !in 6..18) {
            throw AccountException.PasswordRuleNotEnough()
        }
    }

    companion object {
        private val validCharacters: List<String>
            get() {
                return listOf(

                )
            }
    }
}