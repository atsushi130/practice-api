package com.github.atsushi130.practice.domain.usecases.items

import com.github.atsushi130.practice.domain.models.Item

interface ItemUseCase {
    fun getItems(): List<Item>
}