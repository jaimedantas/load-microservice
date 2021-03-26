package com.jaimedantas.service

import br.com.fluentvalidator.Validator
import com.jaimedantas.configuration.PropertiesConfiguration
import com.jaimedantas.model.HelloWorld
import com.jaimedantas.model.Resource
import com.jaimedantas.validators.ResourceValidator
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import java.time.LocalDateTime
import javax.inject.Inject

class LoadSimulator{

    @Inject
    lateinit var propertiesConfiguration: PropertiesConfiguration

    /**
     * Process the request
     */
    suspend fun processLoad(): HelloWorld {

        val currentStartTime = LocalDateTime.now()
        var threadDuration = propertiesConfiguration.processingTime/propertiesConfiguration.threads
        val deferreds: List<Deferred<Unit>> = (1..propertiesConfiguration.threads).map {
            GlobalScope.async {
                BusyThread(threadDuration, currentStartTime)
            }
        }
        deferreds.awaitAll()

        return HelloWorld(propertiesConfiguration.returnMessage)
    }

    /**
     * Puts this thread to work for some time
     */
    private fun BusyThread(duration: Long, startTime: LocalDateTime) {
        while (LocalDateTime.now() < startTime.plusNanos(duration * 1000000)){
            var dummy = 213123
            var dummy2 = dummy * dummy
            dummy += dummy2
            Thread.sleep(50)
        }
    }


}
