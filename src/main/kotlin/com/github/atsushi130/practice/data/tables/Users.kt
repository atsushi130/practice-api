package com.github.atsushi130.practice.data.tables

import com.github.atsushi130.practice.domain.models.User
import org.jetbrains.exposed.dao.*

object Users: IdTable<String>("users") {
    override val id = varchar("id", 36).primaryKey().entityId()
}

class UserEntity(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, UserEntity>(Users)

    fun toModel(): User {
        return User(this.id.value)
    }
}