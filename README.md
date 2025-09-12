# Demo Booking Application

A Spring Boot application for managing a simple movie booking domain. It exposes REST APIs to manage Theatres, Movies, Offers, Shows, Audis, and Bookings.

## Tech Stack

- Java 21
- Spring Boot 3.x
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
- PostgreSQL (JDBC driver included)
- Gradle (using the Gradle Wrapper)

## Project Structure

```
/ (project root)
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/booking/com/booking/
│   │   │       ├── BookingApplication.java
│   │   │       ├── controllers/
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── MovieController.java
│   │   │       │   ├── OfferController.java
│   │   │       │   └── TheatreController.java
│   │   │       ├── repositories/
│   │   │       │   ├── BookingRepository.java
│   │   │       │   ├── MovieRepository.java
│   │   │       │   ├── OfferRepository.java
│   │   │       │   └── TheatreRepository.java
│   │   │       ├── services/
│   │   │       │   ├── BookingService.java
│   │   │       │   ├── MovieService.java
│   │   │       │   ├── OfferService.java
│   │   │       │   └── TheatreService.java
│   │   │       └── Entity/
│   │   │           ├── Audi.java
│   │   │           ├── Booking.java
│   │   │           ├── Movie.java
│   │   │           ├── Offer.java
│   │   │           ├── Show.java
│   │   │           └── Theatre.java
│   │   └── resources/
│   │       └── application.properties (create this)
│   └── test/
└── README.md
```

## Prerequisites

- Java 21 installed (verify with `java -version`).
- PostgreSQL running locally or accessible remotely.

## Configuration

Create `src/main/resources/application.properties` and configure your database connection:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/booking
spring.datasource.username=postgres
spring.datasource.password=postgres
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

## REST API Overview

Base URLs used below assume default port 8080. JSON bodies are illustrative; adjust fields to match your entities.

### Theatres

- GET all theatres

```
curl -X GET http://localhost:8080/api/v1/theatres
```

- GET theatre by id

```
curl -X GET http://localhost:8080/api/v1/theatres/1
```

- POST create theatre

```
curl -X POST http://localhost:8080/api/v1/theatres \
  -H "Content-Type: application/json" \
  -d '{
    "name": "PVR Orion",
    "city": "Bengaluru",
    "state": "KA",
    "pincode": "560055",
    "location": "Orion Mall",
    "phone": "+91-9999999999",
    "email": "info@pvrorion.com",
    "website": "https://pvr.com",
    "image": "https://.../theatre.jpg"
  }'
```

- PUT update theatre

```
curl -X PUT http://localhost:8080/api/v1/theatres/1 \
  -H "Content-Type: application/json" \
  -d '{ "name": "PVR Orion - Updated" }'
```

- DELETE theatre

```
curl -X DELETE http://localhost:8080/api/v1/theatres/1
```

### Movies

- GET all movies

```
curl -X GET http://localhost:8080/api/v1/movies
```

- GET movie by id

```
curl -X GET http://localhost:8080/api/v1/movies/1
```

- POST create movie

```
curl -X POST http://localhost:8080/api/v1/movies \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Inception",
    "description": "Sci-fi thriller",
    "language": "EN"
  }'
```

- PUT update movie

```
curl -X PUT http://localhost:8080/api/v1/movies/1 \
  -H "Content-Type: application/json" \
  -d '{ "name": "Inception - Director\'s Cut" }'
```

- DELETE movie

```
curl -X DELETE http://localhost:8080/api/v1/movies/1
```

### Offers

- GET all offers

```
curl -X GET http://localhost:8080/api/v1/offers
```

- GET offer by id

```
curl -X GET http://localhost:8080/api/v1/offers/1
```

- POST create offer

```
curl -X POST http://localhost:8080/api/v1/offers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Festive10",
    "description": "10% off",
    "discount": "10%",
    "isActive": true
  }'
```

- PUT update offer

```
curl -X PUT http://localhost:8080/api/v1/offers/1 \
  -H "Content-Type: application/json" \
  -d '{ "description": "Flat 10% off" }'
```

- DELETE offer

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
