package com.github.atsushi130.practice.domain.models

import org.springframework.security.crypto.keygen.KeyGenerators

class Salt {
    val value: String = KeyGenerators.string().generateKey()
}