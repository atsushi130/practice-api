package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.data.repositories.UserRepositoryImpl
import com.github.atsushi130.practice.exception.UserException

/**
 * primary key: id
 * user has many items
 */
data class User(val id: String) {

    val items: List<Item>
        get() = Item.findBy(this)

    val userDevice: UserDevice
        get() = UserDevice.findBy(this.id) ?: throw UserException.UserDeviceNotExists()

    val isBanned: Boolean = false

    companion object {

        private val repository = UserRepositoryImpl

        fun findBy(id: String): User? = this.repository.findBy(id)

        fun findFunsBy(itemId: String): List<User> = this.repository.findFunsBy(itemId)
    }
}