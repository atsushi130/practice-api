package com.github.atsushi130.practice.extension

val Int.isOdd: Boolean
    get() = !this.isEven

val Int.isEven: Boolean
    get() = this % 2 == 0
