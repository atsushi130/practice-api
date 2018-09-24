package com.github.atsushi130.practice.presentation.resources

import java.io.Serializable

data class LoginResource(val account: String?, val password: String?): Serializable
