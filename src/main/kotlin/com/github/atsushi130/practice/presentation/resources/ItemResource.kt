package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Item
import java.io.Serializable

data class ItemResource(
    val id: String,
    val name: String,
    val subName: String,
    val registeredUser: UserResource,
    val latestReactionUser: UserResource?,
    val wants: ReactionResource,
    val haves: ReactionResource
): Serializable {
    companion object {
        fun from(model: Item): ItemResource {
            val registeredUser = UserResource.from(model.registeredUser)
            val latestReactionUser = model.latestReactionUser?.let { UserResource.from(it) }
            val wants = ReactionResource.from(model.wants)
            val haves = ReactionResource.from(model.haves)
            return ItemResource(model.id, model.name, model.subName, registeredUser, latestReactionUser, wants, haves)
        }
    }
}