package com.github.atsushi130.practice.domain.models

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
    }
}