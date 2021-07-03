package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.extension.alphabets
import com.github.atsushi130.practice.extension.numbers
import com.github.atsushi130.practice.extension.password
import org.springframework.security.crypto.password.StandardPasswordEncoder

data class Account(val userId: String, val password: String, val salt: String = Salt().value) {

    @Throws(AccountException::class)
    fun validate(): Validated<Account> {
        this.validateAccount()
        this.validatePassword()
        return Validated(this)
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

val Validated<Account>.userId: String
    get() {
        return this.value.userId
    }

val Validated<Account>.hashedPassword: String
    get() {
        val encoder = StandardPasswordEncoder(this.value.salt)
        return encoder.encode(this.value.password)
    }
