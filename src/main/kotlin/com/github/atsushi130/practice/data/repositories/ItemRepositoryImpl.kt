package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.ItemRepository
import java.util.*

class ItemRepositoryImpl {
    companion object: ItemRepository {

        override fun findBy(id: String): Item? {
            return Item(id, "1", "name", "subName")
        }

        override fun findBy(user: User): List<Item> {
            return Arrays.asList(
                Item("1", "F2940B42-20AC-4F74-918F-479FCD547FF5", "name1", "subName1"),
                Item("2", "DC024697-443B-4182-8CBD-8837ACBF7E23", "name2", "subName2"),
                Item("3", "7DDB6B1C-57F7-489A-95FF-2FC7AF12C046", "name3", "subName3"),
                Item("4", "F2940B42-20AC-4F74-918F-479FCD547FF5", "name4", "subName4")
            ).filter {
                it.userId == user.id
            }
        }
    }
}