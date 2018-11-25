package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Reaction
import java.io.Serializable

data class ReactionResource(val state: Boolean, val count: Int): Serializable {
    companion object {
        fun from(model: Reaction): ReactionResource = ReactionResource(model.state, model.count)
    }
}
