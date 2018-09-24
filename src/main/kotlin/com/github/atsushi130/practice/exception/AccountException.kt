package com.github.atsushi130.practice.exception

sealed class AccountException(override val code: Int, override val message: String): PracticeException(code, message) {
    class AccountRuleNotEnough: AccountException(2000, "invalid account name.")
    class PasswordRuleNotEnough: AccountException(2001, "password rule not enough.")
}