package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.dao.IdTable

object Sessions: IdTable<String>("sessions") {
    override val id = varchar("id", 36).primaryKey().entityId()
    val userId = reference("user_id", Users)
}
