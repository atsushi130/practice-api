package com.github.atsushi130.practice.domain.usecases.users

import com.github.atsushi130.practice.domain.models.User

interface UserUseCase {
    fun findFunsBy(itemId: String): List<User>
}