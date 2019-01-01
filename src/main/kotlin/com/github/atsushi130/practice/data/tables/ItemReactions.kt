package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.sql.Table

object ItemReactions: Table("item_reactions") {
    val itemId = integer("item_id")
    val reactionType = varchar("reaction_type", 16)
    val reactedUserId = varchar("reacted_user_id", 36)
}
