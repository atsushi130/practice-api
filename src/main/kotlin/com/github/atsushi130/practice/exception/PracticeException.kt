package com.github.atsushi130.practice.exception

open class PracticeException(open val code: Int, override val message: String): Exception(message)
