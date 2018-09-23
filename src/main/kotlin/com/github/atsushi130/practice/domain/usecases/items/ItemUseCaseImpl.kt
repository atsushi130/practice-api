package com.github.atsushi130.practice.domain.usecases.items

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.shared.UserContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemUseCaseImpl: ItemUseCase {

    @Autowired
    private lateinit var userContainer: UserContainer

    override fun getItems(): List<Item> = this.userContainer.user.items
}