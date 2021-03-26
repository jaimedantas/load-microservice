package com.jaimedantas.controller

import com.jaimedantas.model.HelloWorld
import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
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
    fun shoudReturnMyMessage() {
        val id: String = UUID.randomUUID().toString()
        val uri = "/resource/$id"

        val request: HttpRequest<HelloWorld> = HttpRequest.GET(uri)
        val body = client.toBlocking().retrieve(request)

        assertNotNull(body)
        assertEquals("{\"message\":\"My message\"}", body)
    }

    @Test
    fun shoudReturnBadRequest() {
        val id: String = "invalidId"
        val uri = "/resource/$id"

        val request: HttpRequest<HelloWorld> = HttpRequest.GET(uri)
        try {
            val body = client.toBlocking().retrieve(request)
            fail("Should be bad request")
        } catch(e: HttpClientResponseException){
            assertEquals(HttpStatus.BAD_REQUEST, e.status)
        }
    }


}
