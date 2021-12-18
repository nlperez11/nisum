# Nestor Perez
## Java technical test

[![N|Solid](https://programaenlinea.net/wp-content/uploads/2019/07/java.spring.png)](https://spring.io/projects/spring-boot)
## Techs

For this app i was use the following techs:

- Spring-boot
- Java 11
- H2 in memory database
- Json Web Token
- Swagger
- Junit 5
- lombok
## Installation

This app requires [Java](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) v11+ to run.

```sh
./gradlew clean
./gradlew build
./gradlew bootRun
```

## Base api url

The default base api is http://localhost:8080

## Api Documentation

### This app use swagger for the documentation
When the app is running, see the api documentation for test here : http://localhost:8080/swagger-ui/index.html#/
## Note
For configure the regex password validation, see the properties file
