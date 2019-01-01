package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.ItemRepositoryImpl
import com.github.atsushi130.practice.domain.repositories.ItemRepository

data class Item(
    val id: Int,
    val name: String,
    val subName: String,
    val registeredUserId: String,
    val wants: Reaction,
    val haves: Reaction
) {
    companion object {

        private val repository: ItemRepository = ItemRepositoryImpl

        fun findBy(id: Int): Item? = this.repository.findBy(id)

        fun findBy(userId: String): List<Item> = this.repository.findBy(userId)

        fun getLatest(): List<Item> = this.repository.getLatestItems()
    }
}