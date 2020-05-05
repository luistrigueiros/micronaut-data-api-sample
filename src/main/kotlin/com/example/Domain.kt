package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.AutoPopulated
import javax.persistence.*
import java.util.UUID

@Introspected
data class NameDTO(var name: String)

@Entity
data class Owner(@Id
                 @GeneratedValue
                 var id: Long?,
                 val name: String,
                 val age: Int)


@Entity
data class Pet(@Id
               @AutoPopulated
               var id: UUID?,
               val name: String,
               @ManyToOne
               val owner: Owner,
               val type: PetType = PetType.DOG) {

    enum class PetType {
        DOG,
        CAT
    }
}
