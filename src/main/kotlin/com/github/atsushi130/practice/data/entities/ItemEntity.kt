package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.tables.ItemReactions
import com.github.atsushi130.practice.data.tables.Items
import com.github.atsushi130.practice.domain.models.Item
import com.github.atsushi130.practice.domain.models.Reaction
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.sql.select

class ItemEntity(id: EntityID<Int>): IntEntity(id) {

    companion object : IntEntityClass<ItemEntity>(Items)

    private val name by Items.name
    private val subName by Items.subName
    private val registeredUserId by Items.registeredUserId

    fun toModel(): Item {
        val itemReactions = ItemReactions
            .select { ItemReactions.itemId eq this@ItemEntity.id.value }
            .map { ItemReactionEntity.from(it) }
        val wants = Reaction(false, itemReactions.wantsReactions.count())
        val haves = Reaction(false, itemReactions.havesReactions.count())
        return Item(this.id.value, this.name, this.subName, this.registeredUserId, wants, haves)
    }
}