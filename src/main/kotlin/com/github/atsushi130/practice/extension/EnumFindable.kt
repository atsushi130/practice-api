package com.github.atsushi130.practice.extension

interface EnumFindable<out T>

inline fun <reified T> EnumFindable<T>.findBy(name: String): T? where T: Enum<T> {
    return kotlin.enumValues<T>()
        .find { it.name == name }
}