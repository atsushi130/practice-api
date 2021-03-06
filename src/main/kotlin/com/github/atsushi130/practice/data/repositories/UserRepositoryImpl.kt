package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.tables.Users
import com.github.atsushi130.practice.data.entities.UserEntity
import com.github.atsushi130.practice.domain.models.User
import com.github.atsushi130.practice.domain.repositories.UserRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
@Suppress("unused")
class UserRepositoryImpl: UserRepository {

    override fun findBy(id: String): User? {
        return transaction {
            UserEntity
                .find { Users.id eq id }
                .singleOrNull()
                ?.toModel()
        }
    }

    override fun findFunsBy(itemId: Int): List<User> {
        return emptyList()
    }

    override fun create(id: String): User {
        return transaction {
            UserEntity
                .new(id) {}
                .toModel()
        }
    }
}