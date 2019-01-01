package com.github.atsushi130.practice.domain.models

import com.github.atsushi130.practice.domain.repositories.UserRepository
import com.github.atsushi130.practice.exception.UserException
import org.springframework.beans.factory.annotation.Autowired

/**
 * primary key: id
 * user has many items
 */
data class User(val id: String, val userDevices: List<UserDevice>) {

    val items: List<Item>
        get() = Item.findBy(this.id)

    val isBanned: Boolean = false
}