package com.github.atsushi130.practice.data.tables

import com.github.atsushi130.practice.domain.models.Session
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable

object Sessions: IdTable<String>("sessions") {
    override val id = varchar("id", 36).primaryKey().entityId()
    val userId = reference("user_id", Users)
}

class SessionEntity(id: EntityID<String>): Entity<String>(id) {

    companion object: EntityClass<String, SessionEntity>(Sessions)
    var user by UserEntity referencedOn Sessions.userId

    fun toModel(): Session {
        val user = this.user.toModel()
        return Session(this.id.value, user)
    }
}