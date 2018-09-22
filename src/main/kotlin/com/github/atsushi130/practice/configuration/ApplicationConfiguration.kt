package com.github.atsushi130.practice.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ScopedProxyMode

@Configuration
@ComponentScan(
        scopedProxy = ScopedProxyMode.TARGET_CLASS,
        basePackages = [
            "com.github.atsushi130.practice.presentation"
        ]
)
class ApplicationConfiguration