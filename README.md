# Task Management REST API

A simple REST API developed using Java Spring Boot and Maven.

## Technologies Used
- Java
- Spring Boot
- Maven

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /health | Check application status |
| GET | /todos | Retrieve all tasks |
| POST | /todos | Add a new task |

## Run the Application

mvn spring-boot:run

The application runs on http://localhost:8080.

## Build the Project

mvn clean package

CI Pipeline: Automated using Jenkins with Maven and JUnit tests.

## Example API Requests

### Check Application Health

curl http://localhost:8080/health

### Retrieve All Tasks

curl http://localhost:8080/todos

### Create a New Task

curl -X POST http://localhost:8080/todos \
-H "Content-Type: application/json" \
-d '{"title":"Complete DevOps Assignment"}'
