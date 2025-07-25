# Spring Data Redis CRUD API with Rate Limiting

A simple Spring Boot project demonstrating how to connect to Redis and perform all CRUD (Create, Read, Update, Delete) operations using Spring Data Redis.  
**Now includes rate limiting using Bucket4j and Redis!**

## Features

- Connects to a Redis database
- Implements CRUD operations for the `User` model
- REST API endpoints for Create, Read, Update, Delete
- Rate limiting: restricts clients to 5 requests per minute per IP
- Written in Java (Spring Boot)
- Easily extendable for more models or endpoints

## Prerequisites

- Java 21 or higher
- Redis server running locally (`localhost:6379`) or remotely
- Maven

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/DipankarSethi3012/Spring_Data_Redis.git
   cd Spring_Data_Redis
   ```

2. **Configure Redis**
   Edit `src/main/resources/application.properties` if needed:
   ```
   spring.data.redis.host=localhost
   spring.data.redis.port=6379
   ```

3. **Build and run the project**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Usage

The project exposes endpoints for CRUD operations on `User`:

| Method | Endpoint                | Description         |
|--------|-------------------------|---------------------|
| POST   | `/users`                | Create a user       |
| GET    | `/users/{userId}`       | Get user by ID      |
| GET    | `/users`                | List all users      |
| PUT    | `/users/update/{userId}`| Update user         |
| DELETE | `/users/delete/{userId}`| Delete user         |

**Rate Limiting:**  
Each IP address is limited to 5 requests per minute.  
If you exceed this, you’ll get a `429 Too Many Requests` response.

## How Rate Limiting Works

- Implemented using [Bucket4j](https://bucket4j.com/) and Redis.
- See [`RateLimitFilter`](Project-for-Redis/src/main/java/com/example/demo/filter/RateLimitFilter.java) for details.
- Configured in [`RedisConfig`](Project-for-Redis/src/main/java/com/example/demo/RedisConfig.java).

## Project Structure

- `src/main/java/com/example/demo/model/User.java` – User model
- `src/main/java/com/example/demo/dao/UserDao.java` – Redis CRUD logic
- `src/main/java/com/example/demo/controller/UserController.java` – REST API endpoints
- `src/main/java/com/example/demo/filter/RateLimitFilter.java` – Rate limiting filter
- `src/main/java/com/example/demo/RedisConfig.java` – Redis and Redisson configuration
- `src/main/resources/application.properties` – Redis connection settings

## Dependencies

- Spring Boot Starter Data Redis
- Spring Boot Starter Web
- Bucket4j (rate limiting)
- Redisson (Redis client)
- Lombok (optional, for model)

## Contributing

Pull requests are welcome! Please open an issue first to discuss changes.

## License

MIT License

---

**For more details, see the code files:**
- [Project-for-Redis/src/main/java/com/example/demo/filter/RateLimitFilter.java](Project-for-Redis/src/main/java/com/example/demo/filter/RateLimitFilter.java)
- [Project-for-Redis/src/main/java/com/example/demo/RedisConfig.java](Project-for-Redis/src/main/java/com/example/demo/RedisConfig.java)