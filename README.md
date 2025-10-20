# Bank Account Microservice - REST & GraphQL
Watch the tutorial videos here:
- 🎬 [Watch the demo video on YouTube](https://www.youtube.com/watch?v=2-qIoZcvhAw)
- 🎬 [Watch the demo video on YouTube](https://www.youtube.com/watch?v=FsdR09jlqaE&list=PLDfq1dgDgzfKbYXOJX969jlGGy_Ns-C05&index=3)

## Overview
This project demonstrates the evolution of a Spring Boot microservice from RESTful API to GraphQL implementation. It starts with traditional REST endpoints and extends to include GraphQL for more flexible data querying.

### Part 1: REST API Implementation
A complete RESTful microservice for managing bank accounts with full CRUD operations, built with Spring Boot, Spring Data JPA, and Java 21.

### Part 2: GraphQL Integration
Extends the same microservice with GraphQL support, demonstrating how to expose the same data through multiple API paradigms within a single application.

---

## Features

### REST API Features
- ✅ Complete CRUD operations for bank accounts
- ✅ DTO pattern for clean separation of concerns
- ✅ Swagger/OpenAPI documentation
- ✅ Transaction management and data consistency
- ✅ Lombok for reduced boilerplate code
- ✅ Spring Data JPA with H2 database

### GraphQL Features
- ✅ GraphQL schema with types, queries, and mutations
- ✅ Flexible querying with field selection
- ✅ Entity relationships (Customer ↔ BankAccount)
- ✅ Custom GraphQL exception handling
- ✅ GraphiQL interface for testing
- ✅ Coexistence with REST endpoints

---

## Project Evolution

### Phase 1: REST Implementation
The project began as a traditional REST microservice:
- Spring MVC with imperative programming
- REST controllers with HTTP methods
- API documentation via Swagger UI
- Standard CRUD operations

### Phase 2: GraphQL Enhancement
Extended with GraphQL capabilities:
- Same business logic exposed via GraphQL
- Schema-first development approach
- Enhanced query flexibility
- Multiple API paradigms in one service

---

## Architecture

The microservice follows a layered architecture supporting both REST and GraphQL:

```
┌─────────────────────────────────────────────────┐
│                    Clients                      │
│  ┌─────────────┐  ┌──────────────────────────┐  │
│  │ REST Client │  │   GraphQL Client         │  │
│  └─────────────┘  └──────────────────────────┘  │
└─────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────┐
│                 API Layer                       │
│  ┌─────────────┐  ┌──────────────────────────┐  │
│  │ REST        │  │   GraphQL Controller     │  │
│  │ Controller  │  │   (@QueryMapping,        │  │
│  │             │  │    @MutationMapping)     │  │
│  └─────────────┘  └──────────────────────────┘  │
└─────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────┐
│              Business Layer                      │
│        ┌──────────────────────────┐              │
│        │     Service Layer        │              │
│        │  (Business Logic)        │              │
│        └──────────────────────────┘              │
└─────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────┐
│              Data Access Layer                   │
│        ┌──────────────────────────┐              │
│        │   Repository Layer       │              │
│        │  (Spring Data JPA)       │              │
│        └──────────────────────────┘              │
└─────────────────────────────────────────────────┘
┌─────────────────────────────────────────────────┐
│                 Database                         │
│        ┌──────────────────────────┐              │
│        │       H2 Database        │              │
│        └──────────────────────────┘              │
└─────────────────────────────────────────────────┘
```

---

## Running the Application

### Prerequisites
- Java 21 SDK
- Maven
- IDE (IntelliJ IDEA/Eclipse recommended)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/chaymaAitB/02-bank-account-service.git
   cd 02-bank-account-service
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Access Points
- **REST API Documentation**: http://localhost:8081/swagger-ui.html
- **GraphQL Interface**: http://localhost:8081/graphiql
- **REST Endpoints**: http://localhost:8081/api/...
- **GraphQL Endpoint**: http://localhost:8081/graphql

---

## API Usage Examples

### REST API Examples

**Get all accounts:**
```bash
GET /api/bankAccounts
```

**Create new account:**
```bash
POST /api/bankAccounts
Content-Type: application/json

{
  "balance": 1000.0,
  "type": "SAVINGS",
  "currency": "USD"
}
```

### GraphQL Examples

**Query all accounts with selected fields:**
```graphql
query {
  accountList {
    id
    balance
    type
    currency
  }
}
```

**Create account via mutation:**
```graphql
mutation {
  addAccount( bankAccount:{
    balance: 1500.0
    type: "CURRENT"
    currency: "EUR"
  }) {
    id
    balance
    type
  }
}
```

**Get specific account with relationships:**
```graphql
query {
  bankAccountById(id: "60ce78e1-1d72-4350-ab49-c331dbd4a6bb") {
    id
    balance
    type
    customer {
      id
      name    }
  }
}
```

---

## Testing

### Testing REST API
- Use Swagger UI at `/swagger-ui.html`
- Use Postman or curl for manual testing
  
### Testing GraphQL
- Use GraphiQL interface at `/graphiql`
- Test queries and mutations interactively
---

## Technology Stack

- **Java 21** - Programming language
- **Spring Boot 2.7.3+** - Application framework
- **Spring Data JPA** - Data access
- **H2 Database** - In-memory database
- **GraphQL Spring Boot** - GraphQL integration
- **Lombok** - Code generation
- **Swagger/OpenAPI** - API documentation
- **Maven** - Build tool

---

## Summary

This microservice exemplifies modern API development by supporting both REST and GraphQL paradigms. It shows how to:
- Build robust REST APIs with Spring Boot
- Integrate GraphQL for flexible data querying
- Maintain clean architecture supporting multiple API styles
- Use modern Java features and Spring ecosystem effectively
2. **Feature-based** - Groups all REST features together, then all GraphQL
3. **Versioned** - Explicit version history showing progression

The sequential approach I provided tells a story of your learning journey, which is great for educational purposes!
