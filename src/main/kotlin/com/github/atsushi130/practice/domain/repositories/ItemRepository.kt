package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.models.User

interface ItemRepository {
    fun findBy(id: String): Item?
    fun findBy(user: User): List<Item>
}