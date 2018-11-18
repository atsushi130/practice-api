package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.presentation.resources.UserResource

interface UserPresenter {
    fun getFunsBy(itemId: String): List<UserResource>
}