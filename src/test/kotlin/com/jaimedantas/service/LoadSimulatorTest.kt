package com.jaimedantas.service

import io.micronaut.context.annotation.Property
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@MicronautTest(propertySources = ["application.yml"])
@Property(name = "microservice.threads", value = "1")
class LoadSimulatorTest{


    @Inject
    lateinit var loadSimulator: LoadSimulator

    @Test
    @Property(name = "microservice.processingTime", value = "1000")
    fun shouldTakeTimeDefinedForProcessing() = runBlocking<Unit> {
        val message = "Hello World!"
        val time = 1000

        val startedTime = LocalDateTime.now()
        val result = loadSimulator.processLoad()
        val finishedTime = LocalDateTime.now()

        val validationResult = ChronoUnit.MILLIS.between(startedTime,finishedTime) >= time

        assertTrue(validationResult)
        assertEquals(message, result.message)
    }

}

