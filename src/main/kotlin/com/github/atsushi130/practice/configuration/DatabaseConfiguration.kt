package com.github.atsushi130.practice.configuration

import com.github.atsushi130.practice.data.dataAccessObjects.Sessions
import com.github.atsushi130.practice.data.dataAccessObjects.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class DatabaseConfiguration(@Autowired val dataSource: DataSource): TransactionManagementConfigurer {

    init {
        this.connectDatabase()
        this.createTablesIfNeeded()
    }

    private fun connectDatabase() {
        Database.connect(this.dataSource)
    }

    private fun createTablesIfNeeded() {
        transaction {
            create(Users, Sessions)
        }
    }

    @Bean
    override fun annotationDrivenTransactionManager() = SpringTransactionManager(this.dataSource)
}