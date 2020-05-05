package com.example.controllers

import com.example.api_title
import com.example.api_version
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Hidden
import java.net.URI

fun apiSwaggerUri(): URI = URI.create("/swagger/$api_title-$api_version.yml")

@Hidden
@Controller("/")
class RootController {
    companion object {
        const val SWAGGER_UI_BASE_URL = "webjars/swagger-ui/3.25.1/index.html"
        private fun buildUri() = URI.create("$SWAGGER_UI_BASE_URL?url=${apiSwaggerUri()}")
    }

    @Get
    fun ui() = HttpResponse.redirect<Any>(buildUri())
}

