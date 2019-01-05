package com.github.atsushi130.practice.extension

val Regex.Companion.password: Regex
    get() {
        return Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[!-~]{8,16}")
    }