![Java](https://img.shields.io/badge/Language-Java-blue)
![Maven](https://img.shields.io/badge/Build-Maven-brightgreen)
![TestNG](https://img.shields.io/badge/TestFramework-TestNG-orange)

# 🐾 Pet Store API Automation Framework

An end-to-end **API Automation Testing Framework** built using **RestAssured**, **Java**, and **TestNG**, designed to perform CRUD operations on the Pet Store API. The framework follows the **Page Object Model (POM)** design pattern to ensure maintainability and scalability.

---

## 🚀 Tech Stack

| Tool     | Description                                  |
|----------|----------------------------------------------|
| Java     | Programming language                         |
| RestAssured | API Testing Library                          |
| TestNG   | Testing Framework                            |
| Maven    | Build & Dependency Management                |
| AssertJ  | Fluent Assertion Library                     |
| Jackson  | JSON Serialization/Deserialization        |
| Jenkins  | CI/CD Integration                            |

---

## 📁 Project Structure


````
src
│
├── main/java/PetStore
│ ├── endpoints # Contains all API endpoint methods
│ ├── modules # Reusable logic modules
│ ├── payload # Request payload builders (POJOs)
│
├── test/java/PetStore
│ ├── actions # Reusable action classes for tests
│ ├── tests # TestNG test classes
│ └── resources # Test data, configs, etc.
│
├── pom.xml # Maven project file
├── README.md # Project documentation

````
---

## ✅ Features


- End-to-end integration of Create, Read, Update, and Delete (CRUD) operations with automated API test flows
- Modular and maintainable Page Object Model (POM)
- Strong assertions with AssertJ
- JSON handling with both Jackson
- Supports parallel test execution with TestNG
- Allure report integration for detailed test results
- CI/CD-ready with Jenkins file included

---


