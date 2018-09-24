package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Session
import java.io.Serializable

data class LoginResource(val sessionId: String): Serializable {
    companion object {
        fun from(session: Session): LoginResource = LoginResource(session.id)
    }
}