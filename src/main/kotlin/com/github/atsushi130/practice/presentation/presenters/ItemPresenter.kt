package com.github.atsushi130.practice.presentation.presenters

import com.github.atsushi130.practice.presentation.resources.ItemResource

interface ItemPresenter {
    fun getItems(): List<ItemResource>
}