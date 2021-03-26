package com.jaimedantas.configuration

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("microservice")
class PropertiesConfiguration {

    var processingTime: Long = 0
    var threads: Long = 0
    var returnMessage: String = ""

}
