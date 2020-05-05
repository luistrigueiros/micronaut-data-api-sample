package com.example.controllers

import com.example.Owner
import com.example.repositories.OwnerRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.constraints.NotBlank

@Validated
@Controller("/api/owners")
class OwnerController(private val ownerRepository: OwnerRepository) {

    @Get("/")
    fun all(): List<Owner> {
        return ownerRepository.findAll()
    }

    @Get("/{name}")
    fun byName(@NotBlank name: String): Optional<Owner> {
        return ownerRepository.findByName(name)
    }
}
