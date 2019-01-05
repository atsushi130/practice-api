package com.github.atsushi130.practice.extension

val String.Companion.alphabets: List<String>
    get() {
        return String.lowerAlphabets + String.upperAlphabets
    }

val String.Companion.lowerAlphabets: List<String>
    get() {
        return ('a'..'z').map { it.toString() }
    }

val String.Companion.upperAlphabets: List<String>
    get() {
        return ('A'..'Z').map { it.toString() }
    }

val String.Companion.numbers: List<String>
    get() {
        return ('0'..'9').map { it.toString() }
    }