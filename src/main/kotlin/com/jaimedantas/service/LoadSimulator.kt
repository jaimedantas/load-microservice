package com.jaimedantas.service

import com.jaimedantas.configuration.PropertiesConfiguration
import javax.inject.Inject

class LoadSimulator{

    @Inject
    lateinit var propertiesConfiguration: PropertiesConfiguration

    /**
     * Process the request
     */
    fun processLoad() {
        for (thread in 0 until propertiesConfiguration.threads) {
            BusyThread()
        }
    }

    /**
     * Puts this thread on waiting state
     */
    private fun BusyThread() {
        Thread.sleep(propertiesConfiguration.processingTime/propertiesConfiguration.threads)
    }


}
