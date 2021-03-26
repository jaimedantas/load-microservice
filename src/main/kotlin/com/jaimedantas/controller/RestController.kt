package com.jaimedantas.controller

import br.com.fluentvalidator.Validator
import com.jaimedantas.model.Resource
import com.jaimedantas.service.LoadSimulator
import com.jaimedantas.validators.ResourceValidator
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject


@Controller
class RestController {

    @Inject
    lateinit var loadSimulator: LoadSimulator

    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    val validator: Validator<Resource> = ResourceValidator()


    /**
     * Simulates an API call with some processing.
     */
    @Get(uri = "/resource/{resourceId}")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun loadSimulator(resourceId: String): HttpResponse<Any> {
        val correlationId = UUID.randomUUID()
        val httpResponse: HttpResponse<Any>

        logger.info("Processing request {}", correlationId)
        val validationResult = validator.validate(Resource(resourceId))
        httpResponse = if (validationResult.isValid){
            val response = loadSimulator.processLoad()
            HttpResponse.status<Any>(HttpStatus.OK).body<Any>(response)
        } else {
            HttpResponse.status<Any>(HttpStatus.BAD_REQUEST).body<Any>(validationResult.errors)
        }
        logger.info("Finished Processing {}", correlationId)

        return httpResponse
    }
}
