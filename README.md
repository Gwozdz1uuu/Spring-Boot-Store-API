<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">


# SPRING_BOOT_API

<em>Transform Ideas Into Seamless Digital Experiences</em>

<!-- BADGES -->
<img src="https://img.shields.io/github/last-commit/Gwozdz1uuu/Spring-Boot-Store-API?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/Gwozdz1uuu/Spring-Boot-Store-API?style=flat&color=0080ff" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/Gwozdz1uuu/Spring-Boot-Store-API?style=flat&color=0080ff" alt="repo-language-count">

<em>Built with the tools and technologies:</em>

<img src="https://img.shields.io/badge/Markdown-000000.svg?style=flat&logo=Markdown&logoColor=white" alt="Markdown">
<img src="https://img.shields.io/badge/Spring-000000.svg?style=flat&logo=Spring&logoColor=white" alt="Spring">
<img src="https://img.shields.io/badge/XML-005FAD.svg?style=flat&logo=XML&logoColor=white" alt="XML">
<img src="https://img.shields.io/badge/YAML-CB171E.svg?style=flat&logo=YAML&logoColor=white" alt="YAML">

</div>
<br>

---

## ✨ Overview

Spring-Boot-Store-API is a backend framework built on Spring Boot. It integrates essential components such as data persistence, security, and API documentation, enabling development and third-party integrations like Stripe.

**Why Store API?**

A project for creating secure and easy-to-maintain e-commerce web services.. The core features include:

- **🛡️ Security:** JWT-based authentication and role management ensure secure user sessions.
- **💳 Payment Integration:** Built-in support for Stripe payments facilitates smooth transaction processing.
- **📦 RESTful API:** Comprehensive endpoints for orders, carts, products, and user management.
- **🔧 Error Handling:** Centralized exception management enhances robustness and developer experience.
- **📝 API Documentation:** Integrated with Swagger for clear, accessible API specs.

---

## 📌 Features

|      | Component            | Details                                                                                     |
| :--- | :------------------- | :------------------------------------------------------------------------------------------ |
| ⚙️  | **Architecture**     | <ul><li>Layered architecture with Controllers, Services, Repositories</li><li>RESTful API endpoints</li></ul> |
| 🔩 | **Code Quality**     | <ul><li>Consistent code style with standard Java conventions</li><li>Uses Lombok for boilerplate reduction</li><li>Includes custom exception handling</li><li>Includes Flyway db migrations</li></ul> |
| 📄 | **Documentation**    | <ul><li>Swagger documentation</li><li>API endpoints documented with annotations</li></ul> |
| 🔌 | **Integrations**     | <ul><li>JWT authentication with jjwt library</li><li>Stripe API for payment processing</li><li>Spring Data JPA for database access</li></ul> |
| 🧩 | **Modularity**       | <ul><li>Controllers, services, repositories</li><li>Uses MapStruct for DTO mappings</li><li>Configuration via application.yaml files</li></ul> |
| 🧪 | **Testing**          | <ul><li>Testing in Postman app</li></ul> |
| 🚅 | **Deployment**          | <ul><li>Project deployed on railway.com</li><li>Backend structure</li><li>Database connectivity</li></ul> |
| ⚡️  | **Performance**      | <ul><li>Optimized queries via Spring Data JPA</li></ul> |
| 🛡️ | **Security**         | <ul><li>JWT-based authentication and authorization</li><li>Secure endpoints with Spring Security</li><li>Uses spring-dotenv for environment variables</li></ul> |
| 📦 | **Dependencies**     | <ul><li>Managed via Maven (pom.xml)</li><li>Includes libraries like jjwt, mapstruct, springdoc-openapi, stripe-java</li></ul> |

---

## 📁 Simple Project Structure

```sh
└── Spring_boot_api
        └── src/main/java/com.gwozdz1uu.store
            ├── admin
            ├── auth
            ├── carts
            ├── common
            ├── mappers
            ├── orders
            ├── payments
            ├── products
            └── users
        └── src/main/resources/db.migration
            ├── V1__initial_migration.sql
            (...)
            └── V5__populate_database.sql

```

---

## 📁 More Precise Project Structure Overview

<details open>
<summary><code><b>SPRING_BOOT_API/</b></code></summary>

### 📄 Key Files
- **`pom.xml`** – Project dependencies and build setup.
- **`README.md`** – Project documentation.
- **`script.sql`** – Initial database schema.

### 📁 `src/`
#### 🔹 `main/`
- **`java/com/gwozdz1uu/store`**
  - `StoreApplication.java` – App entry point.
  - **`auth/`** – JWT authentication (token generation, filters, login endpoints).
  - **`users/`** – User profiles, registration, password changes, and roles.
  - **`orders/`** – Order entities, DTOs, services, and controllers.
  - **`carts/`** – Shopping cart logic and API endpoints.
  - **`products/`** – Product/category data and REST access.
  - **`payments/`** – Stripe-based payment processing.
  - **`admin/`** – Admin-only endpoints.
  - **`mappers/`** – DTO ↔ Entity conversion helpers.
  - **`common/`** – Global config, security rules, error handling.

- **`resources/`**
  - `application.yaml` – Base configuration.
  - `application-dev.yaml` – Dev-specific config.
  - `application-prod.yaml` – Prod-specific config.
</details>


---

## 🚀 Getting Started

### 📋 Prerequisites

This project requires the following dependencies:

- **Programming Language:** Java
- **Package Manager:** Maven

### ⚙️ Installation

Build Spring_boot_api from the source and install dependencies:

1. **Clone the repository:**

    ```sh
    ❯ git clone https://github.com/Gwozdz1uuu/Spring_boot_api
    ```

2. **Navigate to the project directory:**

    ```sh
    ❯ cd Spring_boot_api
    ```

3. **Install the dependencies:**

**Using [maven](https://maven.apache.org/):**

```sh
❯ mvn install
```
### 🧪 Testing

Via Postman requests, collections and custom environments such as Dev for local tests and Prod for public server tests.
**[Postman workspace](https://gwozdz1uu.postman.co/workspace/Gwozdz1uu's-Workspace~7045a552-b019-4ec7-8e4e-532e1f39c492/collection/45221523-1906c44e-ac11-4843-babb-dbb8faf74ad8?action=share&creator=45221523&active-environment=45221523-628a6941-32cf-4bad-9255-25ad8882c59e)**

### 🚅 Deployment
Project is deployed on railway.com platform. Includes backend spring rest-API and MySQL already populated database.

### 📄 Documentation
**[Swagger documentation](https://store-api-production-56da.up.railway.app/swagger-ui/index.html)**


<div align="left"><a href="#top">⬆ Return</a></div>

---
