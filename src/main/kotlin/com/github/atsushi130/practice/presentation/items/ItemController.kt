package com.github.atsushi130.practice.presentation.items

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.annotation.RequestScope
import org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestScope
@Component
class ItemController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/items", method = [GET])
    fun getItems(): String {
        return "Items"
    }
}