package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.presentation.resources.ItemResource
import com.github.atsushi130.practice.presentation.resources.ItemResource.Companion.from
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ItemPresenterImpl: ItemPresenter {

    @Autowired
    private lateinit var userContainer: UserContainer

    override fun getItems(): List<ItemResource> = this.userContainer.user.items.map(::from)
}