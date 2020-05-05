package com.example.controllers

import com.example.NameDTO
import com.example.Pet
import com.example.repositories.PetRepository
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import java.util.*


@Validated
@Controller("api/pets")
class PetController(private val petRepository: PetRepository) {

    @Get("/")
    fun all(pageable: Pageable): List<NameDTO> {
        return petRepository.list(pageable)
    }

    @Get("/{name}")
    fun byName(name: String): Optional<Pet> {
        return petRepository.findByName(name)
    }
}
