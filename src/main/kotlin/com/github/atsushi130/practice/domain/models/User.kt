package com.github.atsushi130.practice.domain.models

/**
 * primary key: id
 * user has many items
 */
data class User(val id: String, val userDevices: List<UserDevice>) {
    val isBanned: Boolean = false
}