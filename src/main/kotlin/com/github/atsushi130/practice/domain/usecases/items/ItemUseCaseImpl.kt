package com.github.atsushi130.practice.domain.usecases.items

import com.github.atsushi130.practice.domain.models.Item
import org.springframework.stereotype.Service

@Service
@Suppress("unused")
class ItemUseCaseImpl: ItemUseCase {

    override fun getLatestItems(): List<Item> = Item.getLatest()
}