
# Studio Management Service

A Spring Boot REST API for managing classes, users, and bookings in a studio. This application allows users to create and book classes, manage user information, and provides a Swagger UI for easy testing and documentation.

## Features
- User Management: Create and retrieve users.
- Class Management: Create and view class details with start and end dates.
- Booking Management: Book users into classes on specific dates.
- Swagger Integration: Interactive API documentation with Swagger UI.

## Technology Stack
- Java 21
- Spring Boot 3.3.5
- Springdoc OpenAPI for Swagger Documentation
- Lombok for boilerplate code reduction

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven for dependency management

### Installation

Clone the repository:
```bash
git clone https://github.com/pragati2801/Glofox.git
cd Glofox
```

Build the project with Maven:
```bash
mvn clean install
```

Run the application:
```bash
mvn spring-boot:run
```

The application will start on port `8001` by default.

## Configuration
Configure application settings in `src/main/resources/application.properties`:

```properties
spring.application.name=studio-management-service
server.port=8001
server.servlet.context-path=/api/sms
```

## API Endpoints

### User Management
- `POST /api/sms/v1/user`: Create a new user
- `GET /api/sms/v1/user?userId={userId}` : Retrieve a user by ID
- `GET /api/sms/v1/user/all` : Retrieve all users

### Class Management
- `POST /api/sms/v1/class`: Create a new class
- `GET /api/sms/v1/class?classId={classId}`: Retrieve a class by ID

### Booking Management
- `POST /api/sms/v1/booking`: Create a new booking
- `GET /api/sms/v1/booking?bookingId={bookingId}`: Retrieve a booking by ID
- `GET /api/sms/v1/booking/user?userId={userId}`: Retrieve all booking for User
- `GET /api/sms/v1/booking/all`: Retrieve all bookings
- 
```

