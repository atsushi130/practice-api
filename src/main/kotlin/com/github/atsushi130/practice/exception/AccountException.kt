package com.github.atsushi130.practice.exception

sealed class AccountException(override val code: ExceptionCode, override val message: String): PracticeException(code, message) {
    sealed class AccountRuleNotEnough(code: ExceptionCode.Account, message: String): AccountException(code, message) {
        class InvalidLength: AccountRuleNotEnough(ExceptionCode.Account(0), "user id must be 1-16 characters.")
        class InvalidCharacter: AccountRuleNotEnough(ExceptionCode.Account(1), "contain invalid characters.")
    }
    sealed class PasswordRuleNotEnough(code: ExceptionCode.Account, message: String): AccountException(code, message) {
        class InvalidLength: PasswordRuleNotEnough(ExceptionCode.Account(2), "password must be 8-16 characters.")
        class InvalidCharacter: PasswordRuleNotEnough(ExceptionCode.Account(3), "password must be 8-16 characters and include at least one lowercase letter,one uppercase letter,and a number.")
    }
}