package com.github.atsushi130.practice.domain.models

/**
 * primary key: sessionId
 * session has one user
 */
data class Session(val id: String, val user: User)
