package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Item
import java.io.Serializable

data class ItemResource(
    val id: String,
    val name: String,
    val subName: String
): Serializable {

    companion object {

        fun from(model: Item): ItemResource = ItemResource(model.id, model.name, model.subName)

        fun from(models: List<Item>): List<ItemResource> {
            return models
                .map {
                    ItemResource.from(it)
                }
        }
    }
}