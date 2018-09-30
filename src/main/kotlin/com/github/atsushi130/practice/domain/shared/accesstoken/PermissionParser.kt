package com.github.atsushi130.practice.domain.shared.accesstoken

import com.github.atsushi130.practice.domain.models.Permission

class PermissionParser {
    companion object: Parser<Permission> {
        override fun parseFrom(bearToken: String): Permission {
            // TODO: implementation
            return Permission("", "", "")
        }
    }
}