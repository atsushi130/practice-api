package com.github.atsushi130.practice.extension

import javax.servlet.http.Cookie

val Cookie.isSessionId: Boolean
    get() = this.name == "sessionId"