package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.UserRepositoryImpl

/**
 * primary key: id
 * user has many items
 */
data class User(val id: String) {

    val items: List<Item>
        get() = Item.findBy(this)

    companion object {

        private val repository = UserRepositoryImpl

        fun findBy(id: String): User? = this.repository.findBy(id)
    }
}