package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.dataAccessObjects.Sessions
import com.github.atsushi130.practice.domain.models.Session
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class SessionEntity(id: EntityID<String>): Entity<String>(id) {

    companion object: EntityClass<String, SessionEntity>(Sessions)
    var user by UserEntity referencedOn Sessions.userId

    fun toModel(): Session {
        val user = this.user.toModel()
        return Session(this.id.value, user)
    }
}