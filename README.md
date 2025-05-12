# RTO Vehicle Management API 🚗

A Spring Boot RESTful API for managing vehicle data in an RTO (Regional Transport Office). This API allows basic CRUD operations for vehicle records, along with additional features like search and integration for challans and insurance information.

## 🚀 Features

- Add a new vehicle
- View paginated list of vehicles
- Get vehicle by ID
- Update vehicle details
- Delete a vehicle
- Search vehicles by:
  - Fuel type
  - City
  - State
## 🛠 Tech Stack

- Backend: Spring Boot
- Database: MySQL (RTO_db)
- ORM: Spring Data JPA
- Validation: Hibernate Validator
- Port: 8081
- Testing Tool: Postman

---

## 🔧 Setup Instructions

### 1. Clone the Repository
``
bash
git clone https://github.com/bhavyasingh9822/RTO_-Assignment.git
cd RTO_-Assignment
`
``

### 2. Configure MySQL Database

Create a database named RTO_db:

sql
``CREATE DATABASE RTO_db;``

``
Update src/main/resources/application.properties:
``

properties
``
spring.datasource.url=jdbc:mysql://localhost:3306/RTO_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
``
``
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
``
``
### 3. Run the Application

Using Maven:

bash``
mvn spring-boot:run
``

---

## 📬 API Endpoints

### ➕ Add Vehicle

POST /api/add/vehicle
``
json
{
  "name": "Hyundai Creta",
  "fuel_type": "Petrol",
  "registration_no": "BR 01 AW 0123",
  "owner_name": "Abhishek Kumar",
  "owner_address": "12/2A, Boring Road, Patna 800001",
  "city": "Patna",
  "state": "Bihar"
}
``

### 📋 Get All Vehicles (Paginated)

``GET /api/vehicles?page=0&size=10``

### 🔍 Get Vehicle by ID

``GET /api/vehicle/{id}``

### ✏ Update Vehicle

``PUT /api/vehicle/{id}``
``
json
{
  "name": "Hyundai Creta",
  "fuel_type": "Diesel",
  "registration_no": "BR 01 AW 0145"
}``


### ❌ Delete Vehicle

``DELETE /api/vehicle/{id}``

### 🔍 Search Vehicles

* By Fuel Type: GET /api/vehicles/search?fuel=Petrol
* By State: GET /api/vehicles/search?state=Bihar
* By City: GET /api/vehicles/search?city=Patna

---

## 🛡 Validation & Exception Handling

* Duplicate registration_no restricted
* Required fields are validated
* Global exception handling with @ControllerAdvice
* Returns meaningful HTTP status codes: 201, 404, 400, etc.

---
## 📫 Contact

For issues or suggestions, feel free to open an issue or contact via GitHub.

---
