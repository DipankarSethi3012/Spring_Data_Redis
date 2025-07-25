# Spring_Data_Redis

A simple Spring Boot project demonstrating how to connect to Redis and perform all CRUD (Create, Read, Update, Delete) operations using Spring Data Redis.

## Features

- Connects to a Redis database
- Implements CRUD operations for your data model
- Written entirely in Java
- Easily extendable for additional models or endpoints

## Prerequisites

- Java 8 or higher
- Redis server running locally or remotely
- Maven (for building the project)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/DipankarSethi3012/Spring_Data_Redis.git
   cd Spring_Data_Redis
   ```

2. **Configure Redis**
   Set your Redis connection details in the `application.properties` file:
   ```
   spring.redis.host=localhost
   spring.redis.port=6379
   ```

3. **Build and run the project**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Usage

The project exposes endpoints for CRUD operations. Example endpoints (assuming a model called `User`):

- **Create**: `POST /users`
- **Read**: `GET /users/{id}`
- **Update**: `PUT /users/{id}`
- **Delete**: `DELETE /users/{id}`

To interact, use tools like Postman or curl.

## Project Structure

- `src/main/java/...` – Java source code (controllers, services, repository)
- `src/main/resources/application.properties` – Configuration for Redis connection

## Dependencies

- Spring Boot Starter Data Redis
- Spring Web

## Contributing

Pull requests are welcome! Please open an issue first to discuss what you’d like to change.

## License

This project is licensed under the MIT License.

---

