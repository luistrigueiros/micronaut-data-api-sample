package com.example

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import io.micronaut.data.repository.PageableRepository
import java.util.*

@JdbcRepository(dialect = Dialect.H2)
interface OwnerRepository : CrudRepository<Owner, Long> {

    override fun findAll(): List<Owner>

    fun findByName(name: String): Optional<Owner>
}


@JdbcRepository(dialect = Dialect.H2)
interface PetRepository : PageableRepository<Pet, UUID> {

    fun list(pageable: Pageable): List<NameDTO>

    @Join("owner")
    fun findByName(name: String): Optional<Pet>
}

