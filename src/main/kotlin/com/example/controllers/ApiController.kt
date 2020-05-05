package com.example.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Hidden

@Hidden
@Controller("/api")
class ApiController {
    @Get
    fun index() = apiSwaggerUri().let { HttpResponse.redirect<Any>(it) }
}
