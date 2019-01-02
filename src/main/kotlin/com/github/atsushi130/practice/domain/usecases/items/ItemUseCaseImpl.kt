package com.github.atsushi130.practice.domain.usecases.items

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.repositories.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class ItemUseCaseImpl: ItemUseCase {

    @Autowired
    private lateinit var repository: ItemRepository

    override fun getItems(): List<Item> {
        return emptyList()
    }

    override fun getLatestItems(): List<Item> = this.repository.getLatestItems()
}