# User Management REST API

This project is a Spring Boot-based REST API for managing users, built using Java 17. It supports basic user operations such as creating, reading, updating, and deleting users (CRUD). The project includes Swagger for API documentation, and MapStruct and Lombok are used for object mapping and reducing boilerplate code, respectively.

## Table of Contents
- Database Configuration
- Testing
- Running the Application
- Swagger Documentation
- API Endpoints

## Prerequisites

Before running the project, ensure you have the following installed:

- Java 17 or above
- Maven 3.6+
- MySQL database

## Getting Started

### 1. **Database Configuration**:

To configure the database, you will need to update the `application.properties` file located in the `src/main/resources/` directory. Replace the placeholder values with your actual database connection details.

```
spring.datasource.url=jdbc:mysql://<YOUR DB URL>
spring.datasource.username=<DB USER>
spring.datasource.password=<DB PASSWORD>
```

### 2. **Testing**:
To run the tests, use the following Maven command:
```
mvn test
```

### 3. Running the Application

You can run the application using maven command:

```
mvn spring-boot:run
```

### 4. **Swagger Documentation**:

This project includes Swagger to document and test the API. Once the application is running, you can access the Swagger UI at:

```
http://<deployment-url>/swagger-ui.html
```
### 5. **API Endpoints**:

The following APIs are available:

**1. Create a New User**

```markdown
    - POST `/users`
   
   Request Body:
   {
       "username": "johndoe",
       "firstName": "John",
       "lastName": "Doe",
       "email": "john.doe@example.com",
       "phoneNumber": "1234567890"
   }
```

**2. Get all Users**
```
    - GET `/users`
```

**3. Get User by Id**
```
    - GET `/users/{id}`
```

**4. Update a User**
```markdown
    - PUT `/users/{id}`

   Request Body:
   {
       "username": "johndoe",
       "firstName": "John",
       "lastName": "Doe",
       "email": "john.doe@example.com",
       "phoneNumber": "1234567890"
   }
```

**Delete a User by id**
```
    - DELETE `/users/{id}`
```