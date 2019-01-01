package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Item
import java.io.Serializable

data class ItemResource(
    val id: Int,
    val name: String,
    val subName: String,
    val registeredUserId: String,
    val wants: ReactionResource,
    val haves: ReactionResource
): Serializable {
    companion object {
        fun from(model: Item): ItemResource {
            val wants = ReactionResource.from(model.wants)
            val haves = ReactionResource.from(model.haves)
            return ItemResource(model.id, model.name, model.subName, model.registeredUserId, wants, haves)
        }
    }
}