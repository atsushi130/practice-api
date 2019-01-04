package com.github.atsushi130.practice.interceptor

import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.exception.UserStateException
import com.github.atsushi130.practice.extension.hasNeedHandle
import org.springframework.beans.factory.annotation.Autowired
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
@Component("userStateInterceptor")
@Suppress("unused")
class UserStateInterceptor: HandlerInterceptor {

    @Autowired
    private lateinit var userContainer: UserContainer

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, e: Exception?) {}

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, view: ModelAndView?) {}

    @Throws(UserStateException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (!this.hasNeedHandle(request)) return true
        val user = this.userContainer.user
        if (user.isBanned) throw UserStateException.Banned()
        // FIXME: user appVersion on request header
        if (!user.userDevices.first().device.appVersion.meetsRequiredVersion) throw UserStateException.DoesNotMeetsRequiredVersion()
        return true
    }
}