package com.example.repositories

import com.example.Owner
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*

@JdbcRepository(dialect = Dialect.H2)
interface OwnerRepository : CrudRepository<Owner, Long> {

    override fun findAll(): List<Owner>

    fun findByName(name: String): Optional<Owner>
}
