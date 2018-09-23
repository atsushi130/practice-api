package com.github.atsushi130.practice.domain.usecases.items

import com.github.atsushi130.practice.domain.models.Item
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemUseCaseImpl: ItemUseCase {

    override fun getItems(): List<Item> {
        val item = Item("1", "1", "name1", "subName1")
        return Arrays.asList(item)
    }
}