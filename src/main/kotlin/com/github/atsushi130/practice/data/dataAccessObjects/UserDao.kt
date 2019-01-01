package com.github.atsushi130.practice.data.dataAccessObjects

import com.github.atsushi130.practice.data.tables.UserEntity
import com.github.atsushi130.practice.data.tables.Users
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component

@Component
class UserDao {

    fun findBy(id: String): UserEntity? {
        return transaction {
            UserEntity
                .find { Users.id eq id }
                .singleOrNull()
        }
    }

    fun findFunsBy(itemId: Int): List<UserEntity> {
        return emptyList()
    }
}