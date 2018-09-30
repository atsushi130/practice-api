package com.github.atsushi130.practice.domain.models

/**
 * permission format is "resource:action:license"
 * multiple action define by comma separated list.
 * license is optional.
 */
data class Permission(val resource: String, val action: String, val instance: String?)