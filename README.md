# Booking Service

A Spring Boot-based booking service application that provides RESTful APIs for managing bookings.

## Features

- RESTful API endpoints for booking management
- Spring Data JPA for data persistence
- PostgreSQL database support
- Input validation
- Actuator for application monitoring
- Integration testing with JUnit 5
- Lombok for reducing boilerplate code

## Prerequisites

- Java 21
- Gradle 8.0+
- PostgreSQL 13+

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/booking-service.git
cd booking-service
```

### 2. Configure Database

1. Create a new PostgreSQL database
2. Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookingdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Application

```bash
./gradlew build
```

### 4. Run the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access:

- **API Documentation**: `http://localhost:8080/v3/api-docs`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Actuator Endpoints**: `http://localhost:8080/actuator`

## Project Structure

```
src/
├── main/
│   ├── java/com/booking/
│   │   └── BookingApplication.java      # Main application class
│   │   └── controller/                  # REST controllers
│   │   └── model/                       # Domain models
│   │   └── repository/                  # Data access layer
│   │   └── service/                     # Business logic
│   │       └── serviceImpl/             # Business logic implementation
│   └── resources/
│       ├── application.properties       # Application configuration
│       └── static/                      # Static resources
└── test/                               # Test files
```

## Development

### Running Tests

```bash
./gradlew test
```

### Code Style

This project uses [Google Java Format](https://github.com/google/google-java-format) for code formatting.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/)
- [Project Lombok](https://projectlombok.org/)
