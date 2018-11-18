package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.presentation.resources.UserResource
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPresenterImpl: UserPresenter {

    override fun getFunsBy(itemId: String): List<UserResource> = Arrays.asList()
}