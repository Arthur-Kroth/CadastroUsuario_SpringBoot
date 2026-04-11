<h1 align="center">
  User Registration
</h1>

A complete REST API for user registration, allowing you to create, list, update, and remove users in a simple, efficient, and scalable way. Developed with good architectural practices and modern standards, the application facilitates user registration management and can be easily integrated with different frontend interfaces.

## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Practices adopted

- SOLID, DRY, YAGNI, KISS
- API REST
- Queries with Spring Data JPA
- Dependency Injection
- Error Handling
- Automatic Swagger Generation with OpenAPI 3

## How to Execute

- Clone the git repository
- Build the project:
```
$ ./mvnw clean package
```
- Run the application:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8081](http://localhost:8081).
Swagger can be viewed at [localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## API Endpoints

To make the HTTP requests below, the following tool was used. [httpie](https://httpie.io):

- Create Task
```
$ http POST :8081/user name="User" email="user@email.com"

[
  {
    "email": "user@email.com",
    "id": 1,
    "name": "User"
  }
]
```

- Read Tasks
```
$ http GET :8081/user?email=user@email.com

[
  {
    "email": "user@email.com",
    "id": 1,
    "name": "User"
  }
]
```

- Update Tasks
```
$ http PUT :8081/user?id=1 name="User Main"

[
  {
    "email": "user@email.com",
    "id": 1,
    "name": "User Main"
  }
]
```

- Delete Tasks
```
http DELETE :8081/user?email=user@email.com
[]
```
