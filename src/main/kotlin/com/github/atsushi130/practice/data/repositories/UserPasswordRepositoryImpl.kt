package com.github.atsushi130.practice.data.repositories

import com.github.atsushi130.practice.data.entities.UserPasswordEntity
import com.github.atsushi130.practice.data.tables.UserPasswords
import com.github.atsushi130.practice.domain.models.Account
import com.github.atsushi130.practice.domain.repositories.UserPasswordRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserPasswordRepositoryImpl: UserPasswordRepository {

    override fun create(account: Account) {
        transaction {
            UserPasswords
            .insert {
                it[userId] = account.userId
                it[password] = account.password
            }
        }
    }

    override fun findBy(userId: String): Account? {
        return UserPasswords
            .select { UserPasswords.userId eq userId }
            .map { UserPasswordEntity.from(it) }
            .singleOrNull()
            ?.toAccount()
    }
}