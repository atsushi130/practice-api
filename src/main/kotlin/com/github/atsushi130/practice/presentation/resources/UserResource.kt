package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.User
import java.io.Serializable

data class UserResource(val id: String): Serializable {
    companion object {

        fun from(model: User): UserResource = UserResource(model.id)

        fun from(models: List<User>): List<UserResource> = models.map(::from)
    }
}
