<p align="center"><img src="https://jaimedantas.com/load-microservice/docs/icon.png" height="25%" width="25%"> </p>

# Load Simulator Microservice

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jaimedantas_load-microservice&metric=alert_status)](https://sonarcloud.io/dashboard?id=jaimedantas_load-microservice)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=b3-tax-calculator&metric=coverage)](https://sonarcloud.io/dashboard?id=b3-tax-calculator)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=jaimedantas_load-microservice&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=jaimedantas_load-microservice)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=jaimedantas_load-microservice&metric=security_rating)](https://sonarcloud.io/dashboard?id=jaimedantas_load-microservice)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=jaimedantas_load-microservice&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=jaimedantas_load-microservice)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=jaimedantas_load-microservice&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=jaimedantas_load-microservice)

This microservice simulates a microservice with a REST endpoint at ``/resource/{resource_id}``. There is a tutorial on Medium [here](https://medium.com/reverse-engineering/creating-your-very-first-microservice-with-micronaut-and-kotlin-9be6be4a58d5).

## Languages and frameworks
 - Kotlin 1.4.30
 - Micronaut Framework 2.4.1
 - Swagger UI
 
## Libraries
 - [Java Fluent Validator](https://github.com/mvallim/java-fluent-validator)
 
## Requirements
- JDK 11
- Gradle 6.8.3

## Building From Source
To build from source checkout the code and run:
```
$ gradle clean build
```
## Run
To run the microservice, run:
```
$ java -jar load-simulator-0.1.jar
```
## Documentation
Swagger UI is used for documentation. You can find the information accessing its webpage at:
```
http://localhost:8080/swagger/views/swagger-ui/
```
You can try the API using the Swagger interface embedded on this microservice.  

<p align="center"><img src="https://jaimedantas.com/load-microservice/docs/load_microservice_swagger.png" height="50%" width="50%"> </p>

There is a tutorial on Medium [here](https://medium.com/reverse-engineering/creating-your-very-first-microservice-with-micronaut-and-kotlin-9be6be4a58d5).
## Configuration
The ``processing-time`` property in the``application.yml`` defines the average processing time of each HTTP
request in ms. The minimum value for the processing time is 50ms. You can also define the number of threads and the response
message. 

```
micronaut:
    processing-time: 100
    threads: 2
    return-message: Hello World!
```
