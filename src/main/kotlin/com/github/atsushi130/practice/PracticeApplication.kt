package com.github.atsushi130.practice

import com.github.atsushi130.practice.data.tables.SessionEntity
import com.github.atsushi130.practice.data.tables.Sessions
import com.github.atsushi130.practice.data.tables.UserEntity
import com.github.atsushi130.practice.data.tables.Users
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
class PracticeApplication {
    companion object {
        @JvmStatic fun main(vararg args: String) {
            SpringApplication.run(PracticeApplication::class.java, *args)
            transaction {
                SessionEntity
                    .find {
                        Sessions.id eq "5755BECA-1A85-4714-AF0C-4ECE06E5BE16"
                    }
                    .forEach {
                        println(it.user.id.value)
                    }
            }
        }
    }
}
