package com.github.atsushi130.practice.domain.models

data class Item(
    val id: Int,
    val name: String,
    val subName: String,
    val registeredUserId: String,
    val wants: Reaction,
    val haves: Reaction
)