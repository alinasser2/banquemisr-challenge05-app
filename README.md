
# Banquemisr Challenge 05 App

This is a Spring Boot application designed to manage tasks. The application is built to handle various aspects of task management such as task creation, updating, deleting, and user-specific task search. It implements industry-standard design principles and patterns to ensure clean, maintainable, and scalable code.

## Project Structure

The project follows a clean architecture pattern, divided into several key packages:

- **swagger**: Configured Swagger for API documentation. Access the documentation at `localhost:port/swagger-ui.html`.
- **environment variables**: Environment variables are stored in `.env` files to avoid exposing any secret credentials.
- **logs**: Added logs to track any unhandled situations and important application activities.
- **soft delete**: Added soft delete functionality to avoid permanently losing any data and to allow recovery.
- **config**: Configuration classes for setting up services, security, and application-level settings.
- **dto**: Data Transfer Objects (DTOs) that serve as models for the data exchanged between the controller and service layers.
- **entity**: Entity classes that represent the database tables.
- **enums**: Enum classes representing various fixed values such as task statuses, priorities, and user roles.
- **exception**: Custom exceptions used to handle errors in a standardized way.
- **global exception handler**: A global exception handler to centralize exception handling across the application.
- **mapper**: Mapping interfaces using MapStruct to convert between entities and DTOs.
- **repository**: Data access layer for interacting with the database.
- **security**: Security-related configurations such as JWT handling, authentication, and authorization mechanisms.
- **service**: Core business logic and service implementations.
- **utils**: Utility classes to aid with various functionalities, such as application constants and helper methods.
- **web**: Controllers responsible for handling API requests and responses.
- **database migration files**: Flyway migration scripts for managing database schema changes.
- **docker**: Docker configurations to containerize the application for easy deployment.
- **yml properties file**: Configuration for various application properties like database settings, mail server, and logging.

## Achieving SOLID Principles

This project adheres to the **SOLID** principles, ensuring code flexibility, reusability, and maintainability:

1. **Single Responsibility Principle (SRP)**:
    - Each class has one responsibility, whether it’s the `TaskService` handling the business logic or the `TaskController` dealing with HTTP requests. Services do not handle data persistence directly, as that responsibility is delegated to the `TaskRepository`.

2. **Open/Closed Principle (OCP)**:
    - The project is open for extension but closed for modification. For example, when new task statuses are added, the `TaskStatus` enum can be extended without modifying existing business logic. New features like task filtering can also be added without altering core services.

3. **Liskov Substitution Principle (LSP)**:
    - Interfaces and inheritance are used effectively. For example, custom exceptions extend `RuntimeException`, ensuring that subclasses can be used interchangeably without affecting the application’s functionality.

4. **Interface Segregation Principle (ISP)**:
    - The interfaces are designed to be highly specific. For example, the `TaskServiceInterface` is only implemented by the `TaskServiceImpl` class, allowing for more targeted functionality.

5. **Dependency Inversion Principle (DIP)**:
    - High-level modules depend on abstractions, not concretions. Service classes depend on repository interfaces (`TaskRepository`) and mapper interfaces (`TaskMapper`), ensuring loose coupling and easier testing.

## Design Patterns Used

Several design patterns have been applied in this project to promote good design and scalability:

1. **Factory Method Pattern**:
    - Used for the creation of different types of tasks, depending on the provided input or business logic, enabling a flexible and extensible approach to task creation.

2. **Singleton Pattern**:
    - Applied for certain utility classes that do not require multiple instances, ensuring that only one instance of a class exists and is reused across the application.

3. **Repository Pattern**:
    - Used to separate the data access logic from the business logic, allowing for cleaner code and easier testing.

4. **Service Pattern**:
    - Applied to encapsulate the business logic and provide a clean interface between the controller and repository layers, ensuring that the application is easy to maintain and extend.

## Features

- **Task Management**: Users can create, update, and delete tasks.
- **Task Filtering**: Users can search for tasks based on title, description, status, and due date.
- **Role-Based Access Control**: Users have different roles (admin, user) with different access levels.
- **Task History**: Track task actions such as creation, updates, and deletions.
- **Email Sending on Task Status Change**: The system sends an email notification when a task status changes.
- **Pagination**: Task listings are paginated to improve performance and user experience.

## How to Run

### 1. Set Up Environment Variables

Before running the application, make sure you have set the necessary environment variables. You can use `.env` files for local development:

- `DB_URL`: Database connection URL.
- `DB_USERNAME`: Database username.
- `DB_PASSWORD`: Database password.
- `MAIL_USERNAME`: Email account username for sending notifications.
- `MAIL_PASSWORD`: Email account password.
- `JWT_SECRET_KEY`: The secret key for generating JWT tokens.

### 2. Build and Run the Application

- Build the project using Maven:  
  `mvn clean install`

- Run the application:  
  `mvn spring-boot:run`

### 3. Access Swagger UI

Once the application is running, you can access the API documentation at:
- `http://localhost:8080/swagger-ui.html`

## Test

### Postman Collection

You can download the Postman collection to test the API endpoints from the link below:

- [Download Postman Collection](https://drive.google.com/file/d/1il3tS9m3LHOy3FGdMBKwXEhtPYYDygU5/view?usp=sharing)

### Database Schema

- [Task Management Database Schema Image](https://drive.google.com/file/d/1lZQYEoefrghPca5XD-qXYChdyJDGTFUW/view?usp=sharing)

# **Thank You For Your Time**

