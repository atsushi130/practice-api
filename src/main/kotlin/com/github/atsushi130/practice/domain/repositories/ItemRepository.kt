package com.github.atsushi130.practice.domain.repositories

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.models.User

interface ItemRepository {
    fun findBy(id: Int): Item?
    fun findBy(userId: String): List<Item>
    fun getLatestItems(): List<Item>
}