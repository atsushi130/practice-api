package com.github.atsushi130.practice.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.handler.MappedInterceptor

@Configuration
@ComponentScan(
        scopedProxy = ScopedProxyMode.TARGET_CLASS,
        basePackages = [
            "com.github.atsushi130.practice.presentation",
            "com.github.atsushi130.practice.domain",
            "com.github.atsushi130.practice.data",
            "com.github.atsushi130.practice.interceptor"
        ]
)
class ApplicationConfiguration: WebMvcConfigurer {

    @Autowired
    @Qualifier("appAuthenticationInterceptor")
    private lateinit var authenticationInterceptor: HandlerInterceptor

    @Bean
    fun authenticationInterceptor(): MappedInterceptor = MappedInterceptor(arrayOf("/**"), this.authenticationInterceptor)
}