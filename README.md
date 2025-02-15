# Employee Management System

## Overview
This is a Spring Boot-based REST API for managing employee data. The application provides CRUD operations to create, retrieve, update, and delete employees.

## Technologies Used
- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## Project Structure
```
employee-management-system/
│── src/main/java/com/saurabh/jgrf/ems/
│   ├── controller/
│   │   ├── EmployeeController.java
│   ├── entity/
│   │   ├── Employee.java
│   ├── dto/
│   │   ├── EmployeeDto.java
│   ├── service/
│   │   ├── EmployeeService.java
│   │   ├── impl/EmployeeServiceImpl.java
│   ├── repository/
│   │   ├── EmployeeRepository.java
│   ├── mapper/
│   │   ├── EmployeeMapper.java
│   ├── EmployeeManagementSystemApplication.java
│── src/main/resources/
│   ├── application.properties
│── pom.xml
│── README.md
```

## API Endpoints

### 1. Create Employee
**Endpoint:** `POST /api/employees`
**Request Body:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```
**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

### 2. Get All Employees
**Endpoint:** `GET /api/employees`
**Response:**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com"
  }
]
```

### 3. Get Employee by ID
**Endpoint:** `GET /api/employees/{id}`
**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

### 4. Update Employee
**Endpoint:** `PUT /api/employees/{id}`
**Request Body:**
```json
{
  "firstName": "John",
  "lastName": "Smith",
  "email": "johnsmith@example.com"
}
```
**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Smith",
  "email": "johnsmith@example.com"
}
```

### 5. Delete Employee
**Endpoint:** `DELETE /api/employees/{id}`
**Response:** `204 No Content`

## Setup Instructions
### 1. Clone the Repository
```sh
git clone https://github.com/your-repo/employee-management-system.git
cd employee-management-system
```

### 2. Configure Database
Update `src/main/resources/application.properties` with your PostgreSQL database details:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

### 4. Test APIs
Use Postman or `curl` to test the API endpoints.

## Future Enhancements
- Add Swagger documentation
- Implement exception handling
- Add unit and integration tests

