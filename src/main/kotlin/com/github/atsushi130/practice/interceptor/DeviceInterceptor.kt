package com.github.atsushi130.practice.interceptor

import com.github.atsushi130.practice.domain.models.*
import com.github.atsushi130.practice.domain.shared.DeviceContainer
import com.github.atsushi130.practice.exception.UserDeviceException
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
@Component("deviceInterceptor")
@Suppress("unused")
class DeviceInterceptor: HandlerInterceptor {

    @Autowired
    private lateinit var deviceContainer: DeviceContainer

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, e: Exception?) {}

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, view: ModelAndView?) {}

    @Throws(UserDeviceException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        val osVersion = request.getHeader("OSVersion")
        val _appVersion = request.getHeader("AppVersion")

        val osType = try {
            OS.valueOf(request.getHeader("OS"))
        } catch (throwable: Throwable) {
            throw UserDeviceException.InvalidOSType()
        }

        val appVersion = when (osType) {
            OS.iOS -> iOSAppVersion(_appVersion)
            OS.Android -> AndroidAppVersion(_appVersion)
        }

        val device = Device(osType, OSVersion(osVersion), appVersion)
        this.deviceContainer.setRequestDevice(device)

        return true
    }
}