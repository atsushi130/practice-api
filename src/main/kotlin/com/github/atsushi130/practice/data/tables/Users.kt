package com.github.atsushi130.practice.data.entities

import org.jetbrains.exposed.sql.Table

/**
 * Migration
 *
 * create table users (
 *   id char(36) not null primary key,
 *   name not null unique
 * );
 */
object Users: Table() {
    val id   = varchar("id", 36).primaryKey()
    val name = text("name").uniqueIndex()
}
