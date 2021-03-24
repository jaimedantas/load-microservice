## Load Simulator Microservice
<div>
<img src="/docs/icon.png" width="300px"</img> 
</div>

This microservice simulates a microservice with a REST endpoint at ``/api``.
## Languages and frameworks
 - Kotlin 1.4.30
 - Micronaut Framework 2.4.1
 - Swagger UI
 
## Requirements
- JDK 11
- Gradle

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
Swagger UI is used for documentation. You can find the information accessing its webpage at.
```
http://localhost:8080/swagger/views/swagger-ui/
```
## Configuration
The ``processing-time`` 
property in the``application.yml`` defines the average processing time of each HTTP request takes in ms. You can also define the number of thread. 

```
micronaut:
    processing-time: 200
```
