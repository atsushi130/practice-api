package com.github.atsushi130.practice.data.entities

import com.github.atsushi130.practice.data.tables.UserDevices
import com.github.atsushi130.practice.data.tables.Users
import com.github.atsushi130.practice.domain.models.User
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class UserEntity(id: EntityID<String>): Entity<String>(id) {

    companion object : EntityClass<String, UserEntity>(Users) {
        fun from(model: User): UserEntity {
            return UserEntity(EntityID(model.id, Users))
        }
    }

    val userDevices: List<UserDeviceEntity>
        get() {
            return UserDeviceEntity
                .find { UserDevices.userId eq this@UserEntity.id.value }
                .toList()
        }

    fun toModel(): User {
        val userDevices = this.userDevices
            .map { it.toModel() }
        return User(this.id.value, userDevices)
    }
}