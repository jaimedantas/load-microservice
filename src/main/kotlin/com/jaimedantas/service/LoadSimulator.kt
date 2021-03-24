package com.jaimedantas.service

import com.jaimedantas.configuration.PropertiesConfiguration
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.concurrent.thread
import kotlinx.coroutines.*
import kotlin.system.*

class LoadSimulator{

    @Inject
    lateinit var propertiesConfiguration: PropertiesConfiguration

    /**
     * Process the request
     */
    suspend fun processLoad() {
        val currentStartTime = LocalDateTime.now()
        var threadDuration = propertiesConfiguration.processingTime/propertiesConfiguration.threads
        val deferreds: List<Deferred<Unit>> = (1..propertiesConfiguration.threads).map {
            GlobalScope.async {
                BusyThread(threadDuration, currentStartTime)
            }
        }
        deferreds.awaitAll()
    }

    /**
     * Puts this thread to work for some time
     */
    private fun BusyThread(duration: Long, startTime: LocalDateTime) {
        while (LocalDateTime.now() < startTime.plusNanos(duration*1000000)){
            var dummy = 213123
            var dummy2 = dummy * dummy
            dummy += dummy
            Thread.sleep(50)
        }
    }


}
