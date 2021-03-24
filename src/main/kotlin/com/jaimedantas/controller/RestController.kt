package com.jaimedantas.controller

import com.jaimedantas.service.LoadSimulator
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject


@Controller
class RestController {

    @Inject
    lateinit var loadSimulator: LoadSimulator

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    /**
     * Simulates an API call with some processing.
     */
    @Get(uri = "/api")
    suspend fun loadSimulator(): String {
        val correlationId = UUID.randomUUID()
        logger.info("Processing request {}", correlationId)
        loadSimulator.processLoad()
        logger.info("Finished Processing {}", correlationId)
        return "OK"
    }
}
