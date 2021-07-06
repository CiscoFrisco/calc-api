# calc-api

REST API that provides basic calculator operations. Supports only 2 operands.

Two module architecture that uses RabbitMQ for inter-module communication:

 - **rest:** Receives HTTP requests and forwards a math operation to the RabbitMQ queue

 - **calculator:** Listens for new math operations from the RabbitMQ queue and calculates the desired value accordingly.


## Usage

To test the API, start a RabbitMQ broker first.

Then, in the project's root folder, run the commands:

```
 ./mvnw spring-boot:run -pl rest
 
 ./mvnw spring-boot:run -pl calculator
```

The API currently supports the following endpoints:

 - /sum
    - takes two arguments (a and b) as operands: i.e. /sum?a=1.0&b=2.0
    - if only one argument is provided a default value of 0 is assumed for the missing argument
 
 - /sub
    - takes two arguments (a and b) as operands: i.e. /sub?a=1.0&b=2.0
    - if only one argument is provided a default value of 0 is assumed for the missing argument

 
 - /div
    - takes two arguments (a and b) as operands: i.e. /div?a=1.0&b=2.0
    - if only one argument is provided a default value of 1 is assumed for the missing argument
    - upon detecting divison by 0 returns error message
 
 - /mult
    - takes two arguments (a and b) as operands: i.e. /mult?a=1.0&b=2.0
    - if only one argument is provided a default value of 1 is assumed for the missing argument
