package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.domain.usecases.items.ItemUseCase
import com.github.atsushi130.practice.presentation.resources.ItemResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ItemPresenterImpl: ItemPresenter {

    @Autowired
    private lateinit var useCase: ItemUseCase

    override fun getItems(): List<ItemResource> {
        val items = this.useCase.getItems()
        return ItemResource.from(items)
    }
}