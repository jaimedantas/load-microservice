## Load Simulator Microservice
<div>
<img src="/docs/icon.png" width="300px"</img> 
</div>

This microservice simulates a microservice with a REST endpoint at ``/resource/{resource_id}``.
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
