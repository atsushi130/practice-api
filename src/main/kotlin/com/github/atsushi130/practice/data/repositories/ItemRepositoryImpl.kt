package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.entities.ItemEntity
import com.github.atsushi130.practice.data.tables.Items
import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.repositories.ItemRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
@Suppress("unused")
class ItemRepositoryImpl: ItemRepository {

    override fun findBy(id: Int): Item? {
        return transaction {
            ItemEntity
                .find { Items.id eq id }
                .singleOrNull()
                ?.toModel()
        }
    }

    override fun findBy(registeredUserId: String): List<Item> {
        return transaction {
            ItemEntity
                .find { Items.registeredUserId eq registeredUserId }
                .map { it.toModel() }
        }
    }

    override fun getLatestItems(): List<Item> {
        return transaction {
            ItemEntity
                .all()
                .map { it.toModel() }
        }
    }
}