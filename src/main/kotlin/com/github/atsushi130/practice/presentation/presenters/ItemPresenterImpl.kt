package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.domain.usecases.items.ItemUseCase
import com.github.atsushi130.practice.presentation.resources.ItemResource
import com.github.atsushi130.practice.presentation.resources.ItemResource.Companion.from
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class ItemPresenterImpl: ItemPresenter {

    @Autowired
    private lateinit var userContainer: UserContainer

    @Autowired
    private lateinit var useCase: ItemUseCase

    override fun getItems(): List<ItemResource> = this.userContainer.user.items.map(::from)

    override fun getLatestItems(): List<ItemResource> = this.useCase.getLatestItems().map(::from)
}