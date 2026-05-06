# 🧑‍💼 Job Application REST API

A simple RESTful API built with **Spring Boot** for managing job listings, applicants, and job applications.

## 🚀 Features

* Manage job vacancies (create, read, update, delete)
* Manage applicants
* Submit job applications
* Update application status (submitted, reviewed, accepted, rejected)
* View applicants based on specific job

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* MariaDB / MySQL
* Lombok

## 📦 API Endpoints

### 🔹 Jobs

* `POST /api/jobs` → Create job
* `GET /api/jobs` → Get all jobs
* `GET /api/jobs?name=` → Search jobs
* `PUT /api/jobs/{id}` → Update job
* `DELETE /api/jobs/{id}` → Delete job

### 🔹 Applicants

* `POST /api/applicants` → Create applicant
* `GET /api/applicants` → Get all applicants
* `GET /api/applicants?name=` → Search applicants
* `PUT /api/applicants/{id}` → Update applicant
* `DELETE /api/applicants/{id}` → Delete applicant

### 🔹 Applications

* `POST /api/application/register` → Submit application
* `POST /api/application/change` → Change application status
* `GET /api/application?job=` → Get applications by job

## ⚙️ Configuration

Make sure to configure your database in `application.properties`:

```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/loker
spring.datasource.username=root
spring.datasource.password=your_password
```

## ▶️ How to Run

1. Start your database (MariaDB/MySQL)
2. Create database:

   ```
   CREATE DATABASE loker;
   ```
3. Run the application:

   ```
   mvn spring-boot:run
   ```

## 📌 Notes

* Uses layered architecture: Controller → Service → Repository
* DTO is used for cleaner request handling
* Enum is stored as string for readability

---

Simple project for learning Spring Boot REST API development 🚀
