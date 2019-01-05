package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.extension.alphabets
import com.github.atsushi130.practice.extension.numbers
import com.github.atsushi130.practice.extension.password

data class Account(val userId: String, val password: String) {

    @Throws(AccountException::class)
    fun validate() {
        this.validateAccount()
        this.validatePassword()
    }

    @Throws(AccountException.AccountRuleNotEnough::class)
    private fun validateAccount() {
        if (this.userId.length !in 1..36) throw AccountException.AccountRuleNotEnough.InvalidLength()
        val isValid = this.userId
            .map { it.toString() }
            .fold(true) { sum, character ->
                sum && validCharacters.contains(character)
            }
        if (!isValid) throw AccountException.AccountRuleNotEnough.InvalidCharacter()
    }

    @Throws(AccountException.PasswordRuleNotEnough::class)
    private fun validatePassword() {
        if (this.password.length !in 8..16) throw AccountException.PasswordRuleNotEnough.InvalidLength()
        if (!Regex.password.matches(this.password)) throw AccountException.PasswordRuleNotEnough.InvalidCharacter()
    }

    companion object {
        private val validCharacters: List<String>
            get() {
                return listOf(
                    "-", "_", "."
                ) + String.alphabets + String.numbers
            }
    }
}