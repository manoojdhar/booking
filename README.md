# Movie Booking System

> By Manoj Dhar

A comprehensive Spring Boot application for managing movie bookings, theatres, shows, and offers. This application provides RESTful APIs for managing the entire movie booking lifecycle.

A Spring Boot application for managing a simple movie booking domain. It exposes REST APIs to manage Theatres, Movies, Offers, Shows, Audis, and Bookings.

## 🚀 Tech Stack

- **Java 21** - Modern Java LTS version
- **Spring Boot 3.x** - For building the application
  - Spring Web MVC - For REST APIs
  - Spring Data JPA - For database operations
  - Hibernate - As JPA implementation
  - Hibernate Validator - For request validation
  - SpringDoc OpenAPI - For API documentation
- **PostgreSQL 15+** - Primary database
- **Gradle** - Build tool with Gradle Wrapper
- **Lombok** - For reducing boilerplate code

## 🏗️ Project Structure

```
/ (project root)
├── build.gradle                # Gradle build configuration
├── settings.gradle             # Gradle settings
├── gradlew / gradlew.bat       # Gradle wrapper scripts
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/booking/com/booking/
│   │   │       ├── BookingApplication.java    # Main application class
│   │   │       ├── config/                   # Configuration classes
|   |   |       ├── Exception/                # Exception classes   
│   │   │       ├── controllers/              # REST controllers
│   │   │       │   ├── AudiController.java
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── MovieController.java
│   │   │       │   ├── OfferController.java
│   │   │       │   └── TheatreController.java
│   │   │       ├── repositories/             # JPA repositories
│   │   │       │   ├── AudiRepository.java
│   │   │       │   ├── BookingRepository.java
│   │   │       │   ├── MovieRepository.java
│   │   │       │   ├── OfferRepository.java
│   │   │       │   ├── ShowRepository.java
│   │   │       │   └── TheatreRepository.java
│   │   │       ├── services/                 # Business logic
│   │   │       │   ├── AudiService.java
│   │   │       │   ├── BookingService.java
│   │   │       │   ├── MovieService.java
│   │   │       │   ├── OfferService.java
│   │   │       │   └── TheatreService.java
│   │   │       └── Entity/                   # JPA entities
│   │   │           ├── Audi.java
│   │   │           ├── Booking.java
│   │   │           ├── Movie.java
│   │   │           ├── Offers.java
│   │   │           ├── Show.java
│   │   │           └── Theatre.java
│   │   └── resources/
│   │       ├── application.yml              # Application configuration
│   │       └── db/                          # Database scripts
│   └── test/                                # Test classes
│       └── java/com/booking/com/booking/
│           ├── controllers/
│           └── services/
## ⚙️ Prerequisites

- Java 21 JDK (verify with `java -version`)
- PostgreSQL 15+ (or compatible version)
- Gradle 8.x (included with wrapper)
- Your favorite IDE (IntelliJ IDEA recommended)

## 🔧 Configuration

1. **Database Setup**
   ```sql
   CREATE DATABASE bookingdb;
   CREATE USER booking_user WITH PASSWORD 'your_secure_password';
   GRANT ALL PRIVILEGES ON DATABASE bookingdb TO booking_user;
   ```

2. **Application Configuration**
   Update `src/main/resources/application.yml` with your database credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/bookingdb
       username: booking_user
       password: your_secure_password
   ```

## 🚀 Running the Application

1. **Using Gradle Wrapper**
   ```bash
   ./gradlew bootRun
   ```

2. **Build and Run**
   ```bash
   ./gradlew build
   java -jar build/libs/booking-0.0.1-SNAPSHOT.jar
   ```

   The application will be available at: http://localhost:8000

## 📚 API Documentation

Once the application is running, you can access:

- **Swagger UI**: http://localhost:8000/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8000/api-docs

## 🧪 Testing

Run the test suite with:
```bash
./gradlew test
```

## 📦 Dependencies

Key dependencies used in this project:

- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Lombok
- PostgreSQL Driver
- SpringDoc OpenAPI
- Hibernate Validator
- Spring Boot DevTools

Create `src/main/resources/application.properties` and configure your database connection:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/bookingdbname
spring.datasource.username=postgresUsername
spring.datasource.password=postgresPassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Optional: change server port
# server.port=8080
```

Adjust the values according to your environment.

## Build and Run

- Build the project:

```
./gradlew clean build
```

- Run the application:

```
./gradlew bootRun
```

The app starts on `http://localhost:8080` by default.

## 🌐 API Endpoints

### 🎭 Theatres

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`    | `/api/v1/theatres` | Get all theatres |
| `POST`   | `/api/v1/theatres` | Create a new theatre |
| `GET`    | `/api/v1/theatres/{id}` | Get a specific theatre |
| `PUT`    | `/api/v1/theatres/{id}` | Update a theatre |
| `DELETE` | `/api/v1/theatres/{id}` | Delete a theatre |

### 🎬 Movies

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`    | `/api/v1/movies` | Get all movies |
| `POST`   | `/api/v1/movies` | Create a new movie |
| `GET`    | `/api/v1/movies/{id}` | Get a specific movie |
| `PUT`    | `/api/v1/movies/{id}` | Update a movie |
| `DELETE` | `/api/v1/movies/{id}` | Delete a movie |

### 🎁 Offers

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`    | `/api/v1/offers` | Get all offers |
| `POST`   | `/api/v1/offers` | Create a new offer |
| `GET`    | `/api/v1/offers/{id}` | Get a specific offer |
| `PUT`    | `/api/v1/offers/{id}` | Update an offer |
| `DELETE` | `/api/v1/offers/{id}` | Delete an offer |

### 🎟️ Bookings

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`    | `/api/v1/bookings` | Get all bookings |
| `POST`   | `/api/v1/bookings` | Create a new booking |
| `GET`    | `/api/v1/bookings/{id}` | Get a specific booking |
| `PUT`    | `/api/v1/bookings/{id}` | Update a booking |
| `DELETE` | `/api/v1/bookings/{id}` | Delete a booking |

## 📝 Examples

### Create a New Theatre

```bash
curl -X POST http://localhost:8000/api/v1/theatres \
  -H "Content-Type: application/json" \
  -d '{
    "name": "PVR Cinemas",
    "location": "MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001",
    "phone": "+911234567890",
    "email": "info@pvr.com",
    "website": "https://www.pvrcinemas.com"
  }'
```

### Create a New Movie

```bash
curl -X POST http://localhost:8000/api/v1/movies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Inception",
    "description": "A thief who steals corporate secrets through the use of dream-sharing technology...",
    "duration": "148",
    "genre": "Sci-Fi",
    "language": "English",
    "releaseDate": "2023-07-15",
    "status": "RELEASED"
  }'
```

### Create a New Booking

```bash
curl -X POST http://localhost:8000/api/v1/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "movieId": 1,
    "theatreId": 1,
    "showTime": "2023-07-20T18:30:00",
    "seatNumber": "A12",
    "userId": 1
  }'
```

## 🚨 Error Handling

The API returns appropriate HTTP status codes and structured error responses.

Example error response (404 Not Found):

```json
{
  "timestamp": "2023-07-15T12:34:56.789+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Theatre not found with id: 999",
  "path": "/api/v1/theatres/999"
}
```
curl -X DELETE http://localhost:8080/api/v1/offers/1
```

### Bookings

If you expose bookings under `/api/v1/bookings`, typical operations are:

```
GET    /api/v1/bookings
GET    /api/v1/bookings/{id}
POST   /api/v1/bookings
PUT    /api/v1/bookings/{id}
DELETE /api/v1/bookings/{id}
```

Adjust according to your `BookingController` implementation.

## Database Schema

JPA/Hibernate will manage schema updates if `spring.jpa.hibernate.ddl-auto=update` is set. For production, prefer migrating with tools like Flyway or Liquibase.

## Development Tips

- Enable SQL logging during development with `spring.jpa.show-sql=true`.
- Use Postman/Insomnia or cURL to test endpoints.
- Keep your entity relationships (`@OneToMany`, `@ManyToOne`, `@ManyToMany`) aligned to your use cases to avoid N+1 queries; consider DTOs for API responses in larger systems.

## Running Tests

```
./gradlew test
```

## License

This project is provided as-is for demonstration purposes.
