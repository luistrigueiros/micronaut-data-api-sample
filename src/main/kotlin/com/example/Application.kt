package com.example

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*
import java.net.URI

const val api_title = "demo"
const val api_version = "1.0"

@OpenAPIDefinition(
    info = Info(
            title = api_title,
            version = api_version,
            description = "Relying Parties API",
            license = License(name = "Apache 2.0", url = "https://www2.deloitte.com/ie/en.html"),
            contact = Contact(
                    url = "https://www2.deloitte.com/ie/en/pages/technology/topics/blockchain-lab.html/ie/en.html",
                    name = "Deloitte Blockchain Lab",
                    email = "blockchain.lab@deloitte.ie")
    )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.example")
                .mainClass(Application.javaClass)
                .start()
    }
}
