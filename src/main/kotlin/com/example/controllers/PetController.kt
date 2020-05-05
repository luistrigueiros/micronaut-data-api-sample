package com.example.controllers

import com.example.*
import java.util.Optional

import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated


@Validated
@Controller("api/pets")
open class PetController(private val petRepository: PetRepository) {

    @Get("/")
    fun all(pageable: Pageable): List<NameDTO> {
        return petRepository.list(pageable)
    }

    @Get("/{name}")
    fun byName(name: String): Optional<Pet> {
        return petRepository.findByName(name)
    }
}
