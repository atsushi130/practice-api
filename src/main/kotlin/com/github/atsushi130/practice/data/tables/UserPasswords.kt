package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.sql.Table

object UserPasswords: Table("user_passwords") {
    val userId = varchar("user_id", 36).uniqueIndex()
    val password = varchar("password", 16)
}