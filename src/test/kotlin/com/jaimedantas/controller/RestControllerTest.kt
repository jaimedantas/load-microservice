package com.jaimedantas.controller

import com.jaimedantas.model.HelloWorld
import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import javax.inject.Inject

@MicronautTest(propertySources = ["application.yml"])
class RestControllerTest{

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient

    @Test
    @Property(name = "microservice.returnMessage", value = "My message")
    fun shoudReturnHelloWorld() {
        var id: String = UUID.randomUUID().toString()
        var uri = "/resource/$id"

        val request: HttpRequest<HelloWorld> = HttpRequest.GET(uri)
        val body = client.toBlocking().retrieve(request)

        Assertions.assertNotNull(body)
        Assertions.assertEquals("{\"message\":\"My message\"}", body)
    }


}
