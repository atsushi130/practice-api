package com.github.atsushi130.practice.exception

sealed class AccountException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    class AccountRuleNotEnough: AccountException(ExceptionCode.Account(0), "invalid account name.")
    class PasswordRuleNotEnough: AccountException(ExceptionCode.Account(1), "password rule not enough.")
}