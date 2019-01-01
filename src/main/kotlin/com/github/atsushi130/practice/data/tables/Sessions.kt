package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable

object Sessions: IdTable<String>("sessions") {
    override val id = varchar("id", 36).primaryKey().entityId()
    val user = reference("user_id", Users)
}

class SessionEntity(id: EntityID<String>): Entity<String>(id) {
    companion object: EntityClass<String, SessionEntity>(Sessions)
    var user by UserEntity referencedOn Sessions.user
}