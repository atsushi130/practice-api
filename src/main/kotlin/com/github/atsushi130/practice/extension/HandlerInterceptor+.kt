package com.github.atsushi130.practice.extension

import com.github.atsushi130.practice.common.NonLoginRequestUri
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest

inline fun HandlerInterceptor.hasNeedHandle(request: HttpServletRequest): Boolean {
    return !NonLoginRequestUri.contains(request.requestURI)
}