package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.presentation.resources.UserResource

interface UserPresenter {
    fun getUser(): UserResource
    fun findFunsBy(itemId: Int): List<UserResource>
}