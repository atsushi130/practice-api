package com.github.atsushi130.practice.exception

/**
 * exception code
 * Authentication: 1xxx
 * Account: 2xxx
 * Login: 3xxx
 * User: 4xxx
 * UserState: 5xxx
 * UserDevice: 6xxx
 */
sealed class ExceptionCode(open val value: Int) {
    class Authentication(no: Int): ExceptionCode(1000 + no)
    class Account(no: Int): ExceptionCode(2000 + no)
    class Login(no: Int): ExceptionCode(3000 + no)
    class User(no: Int): ExceptionCode(4000 + no)
    class UserState(no: Int): ExceptionCode(5000 + no)
    class UserDevice(no: Int): ExceptionCode(6000 + no)
}