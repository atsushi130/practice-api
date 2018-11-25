package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.ItemRepositoryImpl
import com.github.atsushi130.practice.domain.repositories.ItemRepository

data class Item(
    val id: String,
    val name: String,
    val subName: String,
    val registeredUser: User,
    val latestReactionUser: User?,
    val wants: Reaction,
    val haves: Reaction
) {
    companion object {

        private val repository: ItemRepository = ItemRepositoryImpl

        fun findBy(id: String): Item? = this.repository.findBy(id)

        fun findBy(user: User): List<Item> = this.repository.findBy(user)

        fun getLatest(): List<Item> = this.repository.getLatestItems()
    }
}