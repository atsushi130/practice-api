package com.github.atsushi130.practice.presentation.resources

import com.github.atsushi130.practice.domain.models.Session
import java.io.Serializable

data class SessionResource(val sessionId: String): Serializable {
    companion object {
        fun from(session: Session): SessionResource = SessionResource(session.id)
    }
}