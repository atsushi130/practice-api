package com.github.atsushi130.practice.interceptor

import com.github.atsushi130.practice.domain.shared.accesstoken.AccessTokenParser
import com.github.atsushi130.practice.exception.AuthenticationException
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RequestScope
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component("appAuthenticationInterceptor")
class AuthenticationInterceptor: HandlerInterceptor {

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, e: Exception?) {}

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, view: ModelAndView?) {}

    @Throws(AuthenticationException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        /**
         * when bearer token does not exists, return 401 error on header.
         */
        val maybeAuthenticationHeader: String? = request.getHeader("Authentication")
        val authenticationHeader = maybeAuthenticationHeader ?: throw AuthenticationException.AuthenticationHeaderNotExists()

        val accessToken = AccessTokenParser.parseFrom(authenticationHeader)

        /**
         * validate permission.
         */

        return true
    }
}