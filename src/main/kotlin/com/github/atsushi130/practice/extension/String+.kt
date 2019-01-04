package com.github.atsushi130.practice.extension

val String.Companion.alphabets: List<String>
    get() {
        return ('a'..'z').map { it.toString() }
    }