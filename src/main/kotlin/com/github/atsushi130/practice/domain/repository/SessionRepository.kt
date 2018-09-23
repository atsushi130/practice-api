package com.github.atsushi130.practice.domain.repository

import com.github.atsushi130.practice.domain.models.Session

interface SessionRepository {
    fun findBy(id: String): Session?
}