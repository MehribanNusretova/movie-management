# 🎬 Movie Management API

A RESTful Movie Management API built with **Java**, **Spring Boot**, and **PostgreSQL** following **Layered Architecture** and **DTO-based communication**.

---

## ✨ Features

- 🎥 Create, Read, Update and Delete Movies
- 📦 Layered Architecture (Controller → Service → Repository)
- 🔄 DTO Mapping with MapStruct
- ✅ Request Validation
- ⚠️ Global Exception Handling
- 🗄️ PostgreSQL Database
- 🐳 Docker Compose Support
- 📬 Postman Collection
- 📖 Clean and Maintainable Code

---

## 🛠️ Tech Stack

| Technology | Version |
|------------|----------|
| ☕ Java | 21 |
| 🌱 Spring Boot | 3.x |
| 📦 Spring Data JPA | Latest |
| 🐘 PostgreSQL | 16 |
| 🗺️ MapStruct | Latest |
| 🟣 Lombok | Latest |
| 🐳 Docker Compose | Latest |
| 🧪 Postman | API Testing |
| 🛠️ Gradle | Build Tool |
| 🌐 REST API | HTTP |

---

## 📂 Project Structure

```
src
 ├── controller
 ├── dto
 ├── entity
 ├── mapper
 ├── repository
 ├── service
 │     └── impl
 ├── exception
 ├── validation
 └── resources
```

---

## 🚀 Getting Started

### Clone Repository

```bash
git clone https://github.com/MehribanNusretova/movie-management.git
```

```bash
cd movie-management
```

---

## 🐳 Run PostgreSQL

```bash
docker compose up -d
```

---

## ⚙️ Configure Database

`application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movie_db
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update
```

---

## ▶️ Run Application

```bash
./gradlew bootRun
```

or

Run **MovieManagementApplication** from IntelliJ IDEA.

---

## 📬 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /movies | Get all movies |
| GET | /movies/{id} | Get movie by id |
| POST | /movies | Create movie |
| PUT | /movies/{id} | Update movie |
| DELETE | /movies/{id} | Delete movie |

---

## 📮 Postman Collection

```
postman/MovieManagementAPI.postman_collection.json
```

Import this collection into Postman to test all endpoints.

---

## 📌 Validation

The project uses Bean Validation.

Examples:

- @NotBlank
- @NotNull
- @Email
- @Valid

---

## ⚠️ Exception Handling

Global exception handling is implemented using

- @RestControllerAdvice
- @ExceptionHandler

Custom exceptions:

- NotFoundException

---

## 📸 Sample Response

```json
{
    "id":1,
    "title":"Inception",
    "description":"Science fiction movie",
    "releaseYear":2010,
    "rating":9.2
}
```

---

## 👩‍💻 Author

**Mehriban Nusratova**

GitHub:

https://github.com/MehribanNusretova

LinkedIn:

(Add your LinkedIn profile here)

---

⭐ If you like this project, don't forget to give it a star.
