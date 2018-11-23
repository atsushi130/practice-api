package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.domain.usecases.users.UserUseCase
import com.github.atsushi130.practice.presentation.resources.UserResource
import com.github.atsushi130.practice.presentation.resources.UserResource.Companion.from
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class UserPresenterImpl: UserPresenter {


    @Autowired
    private lateinit var userContainer: UserContainer

    @Autowired
    private lateinit var useCase: UserUseCase

    override fun getUser(): UserResource = UserResource.from(this.userContainer.user)


    override fun findFunsBy(itemId: String): List<UserResource> = this.useCase.findFunsBy(itemId).map(::from)
}