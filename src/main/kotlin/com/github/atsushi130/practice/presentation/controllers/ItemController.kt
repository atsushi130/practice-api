package com.github.atsushi130.practice.presentation.controllers

import com.github.atsushi130.practice.presentation.presenters.ItemPresenter
import com.github.atsushi130.practice.presentation.resources.ItemResource
import org.springframework.beans.factory.annotation.Autowired
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
@Suppress("unused")
class ItemController {

    @Autowired
    private lateinit var presenter: ItemPresenter

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = ["/items"], method = [GET])
    fun getItems(): List<ItemResource> = this.presenter.getItems()
}