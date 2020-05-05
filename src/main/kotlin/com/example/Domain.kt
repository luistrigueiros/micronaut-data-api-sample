package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.AutoPopulated
import java.util.*
import javax.persistence.*

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

@Entity
@Table(name = "CLIENT_DETAILS")
data class ClientDetails(
        @Id
        @GeneratedValue
        var id: Long?,
        @Column(name = "CLIENT_ID")
        val clientID: String,
        @Column(name = "CLIENT_NAME")
        val clientName: String,
        @Column(name = "CLIENT_DESCRIPTION")
        val clientDescription: String?
)
