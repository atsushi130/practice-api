package com.github.atsushi130.practice.domain.shared.accesstoken

interface Parser<T> {
    fun parseFrom(arg1: String): T
}