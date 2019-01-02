package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.dao.IdTable

object Users: IdTable<String>("users") {
    override val id = varchar("id", 36).primaryKey().entityId()
}
