package com.github.atsushi130.practice.data.tables

import org.jetbrains.exposed.dao.IntIdTable

object Items: IntIdTable("items") {
    val name = text("name")
    val subName = text("sub_name")
    val registeredUserId = varchar("registered_user_id", 36)
}