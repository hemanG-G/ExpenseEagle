# User Service - Expense Tracker Service

The User Service is responsible for managing user information. It saves user data received from an authentication service through Kafka and provides various endpoints for managing user-related information.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)
- [Todo](#Todo)

## Features

- Save user information received from the Auth Service via Kafka.
- Manage user info through various endpoints.
- CRUD operations for user data.

## Getting Started

### Prerequisites

- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Kafka](https://kafka.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)

### Installation

1. **Get the UserService repository:**


2. **Set up MySQL:**

   Make sure you have MySQL installed and running. Create a database for the service.

3. **Configure the application:**

   Update the `application.properties` file with your database and Kafka configurations.

4. **Build and run the service:**

    ```sh
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

### Usage

The User Service listens to Kafka topics for user information and provides RESTful endpoints for managing user data.

### API Endpoints

#### User Endpoints

- **Create User**
    - **URL:** `/users`
    - **Method:** `POST`
    - **Description:** Create a new user.
    - **Request Body:**
      ```json
      {
        "username": "string",
        "email": "string",
        "password": "string"
      }
      ```

- **Get User by ID**
    - **URL:** `/users/{id}`
    - **Method:** `GET`
    - **Description:** Retrieve user information by user ID.

- **Update User**
    - **URL:** `/users/{id}`
    - **Method:** `PUT`
    - **Description:** Update user information.
    - **Request Body:**
      ```json
      {
        "username": "string",
        "email": "string"
      }
      ```

- **Delete User**
    - **URL:** `/users/{id}`
    - **Method:** `DELETE`
    - **Description:** Delete a user by ID.

#### Kafka Listener

The service listens to the `auth-service` topic for user information and processes the messages to save or update user data in the database.

### Configuration

The application configuration is managed through the `application.properties` file. Ensure to update the following properties:

```dosini
POSTGRES_HOST=db.example.com
POSTGRES_PORT=5432
POSTGRES_USER=myuser
POSTGRES_PASSWORD=mypassword
POSTGRES_DB=mydatabase
KAFKA_HOST=kafka.example.com
KAFKA_PORT=9092
USER_SERVICE_PORT=8080
```

## Todo
- [ ] Add more endpoints


