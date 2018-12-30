package com.github.atsushi130.practice.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.jetbrains.exposed.sql.Database
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class DataBaseConfiguration(@Autowired val dataSource: DataSource): TransactionManagementConfigurer {

    init {
        Database.connect(this.dataSource)
    }

    @Bean
    override fun annotationDrivenTransactionManager() = SpringTransactionManager(this.dataSource)
}