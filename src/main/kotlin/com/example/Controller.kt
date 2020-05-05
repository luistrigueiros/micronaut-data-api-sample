package com.example

import com.example.*
import java.util.Optional

import javax.validation.constraints.NotBlank

import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/owners")
open class OwnerController(private val ownerRepository: OwnerRepository) {

    @Get("/")
    fun all(): List<Owner> {
        return ownerRepository.findAll()
    }

    @Get("/{name}")
    open fun byName(@NotBlank name: String): Optional<Owner> {
        return ownerRepository.findByName(name)
    }
}

@Controller("/pets")
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
