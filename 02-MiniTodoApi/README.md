# 📝 MiniTodo API

A simple layered Spring Boot application demonstrating clean architecture principles — separation of concerns between domain, application, infrastructure, and presentation layers.

This project provides a minimal yet realistic example of how to structure and implement a RESTful API using Spring Boot, JPA, and PostgreSQL/H2.

## 🏗️ Architecture
```
minitodoapi
├── application
│   ├── TodoService.java        // Interface (business contract)
│   └── impl
│       └── TodoServiceImpl.java // Service implementation
├── domain
│   └── Todo.java                // JPA entity
├── infrastructure
│   └── repository
│       └── TodoRepository.java  // Extends JpaRepository
└── presentation
└── TodoController.java      // REST endpoints
```


Domain → Core business model (Todo)

Application → Service interfaces + logic

Infrastructure → Database & repository layer

Presentation → REST controllers

## ⚙️ Technologies

- Java 21+ 
- Spring Boot 3+ 
- Spring Data JPA 
- H2 (in-memory)
- Maven