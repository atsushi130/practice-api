package com.github.atsushi130.practice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
class PracticeApplication {
    companion object {
        @JvmStatic fun main(vararg args: String) {
            SpringApplication.run(PracticeApplication::class.java, *args)
        }
    }
}
