package com.github.atsushi130.practice.domain.models

/**
 * primary key: id
 * user has many items
 */
data class User(val id: String) {

    val items: List<Item>
        get() = Item.findBy(this)

    companion object {
        fun findBy(id: String): User? {
            return User("1")
        }
    }
}