package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.exception.AccountException
import com.github.atsushi130.practice.presentation.resources.AccountResource
import com.github.atsushi130.practice.presentation.resources.SessionResource

interface AccountPresenter {

    @Throws(AccountException::class)
    fun signUp(account: AccountResource): SessionResource

    @Throws(AccountException::class)
    fun signIn(account: AccountResource): SessionResource
}