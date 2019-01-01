package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.tables.ItemReactions
import org.jetbrains.exposed.sql.ResultRow

data class ItemReactionEntity(val itemId: Int, val reactionType: String, val reacted_user_id: String) {
    companion object {
        fun from(row: ResultRow): ItemReactionEntity {
            return ItemReactionEntity(row[ItemReactions.itemId], row[ItemReactions.reactionType], row[ItemReactions.reactedUserId])
        }
    }
}

val List<ItemReactionEntity>.wantsReactions: List<ItemReactionEntity>
    get() {
        return this
            .filter { it.reactionType == "wants" }
    }

val List<ItemReactionEntity>.havesReactions: List<ItemReactionEntity>
    get() {
        return this
            .filter { it.reactionType == "haves" }
    }
