package com.github.atsushi130.practice.domain.models

import java.util.*

data class Item(
    val id: String,
    val userId: String,
    val name: String,
    val subName: String
) {
    companion object {

        fun findBy(id: String): Item? {
            return Item(id, "1", "name1", "subName1")
        }

        fun findBy(user: User): List<Item> {
            val item = Item(user.id, "1", "name1", "subName1")
            return Arrays.asList(item)
        }
    }
}