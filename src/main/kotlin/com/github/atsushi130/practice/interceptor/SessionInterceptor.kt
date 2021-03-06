package com.github.atsushi130.practice.interceptor

import com.github.atsushi130.practice.domain.repositories.SessionRepository
import com.github.atsushi130.practice.domain.shared.UserContainer
import com.github.atsushi130.practice.exception.AuthenticationException
import com.github.atsushi130.practice.extension.hasNeedHandle
import com.github.atsushi130.practice.extension.isSessionId
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
@Component("sessionInterceptor")
@Suppress("unused")
class SessionInterceptor: HandlerInterceptor {

    @Autowired
    private lateinit var userContainer: UserContainer

    @Autowired
    private lateinit var sessionRepository: SessionRepository

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, e: Exception?) {}

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, view: ModelAndView?) {}

    @Throws(AuthenticationException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        if (!this.hasNeedHandle(request)) return true

        val cookies = request.cookies.toList()
        if (cookies.isEmpty()) throw AuthenticationException.CookieNotExists()

        val sessionId = cookies
            .firstOrNull { it.isSessionId }
            ?: throw AuthenticationException.SessionIdNotExists()

        val session = this.sessionRepository.findBySessionId(sessionId.value)
            ?: throw AuthenticationException.InvalidSessionId()

        // set authenticated user to shared user container.
        this.userContainer.setAuthenticatedUser(session.user)

        return true
    }
}
