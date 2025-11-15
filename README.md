# 🧪 API Testing Framework  
### Java | RestAssured | TestNG | Cucumber | JDBC | Maven

![Java](https://img.shields.io/badge/Java-17-orange)
![TestNG](https://img.shields.io/badge/TestNG-Framework-blue)
![RestAssured](https://img.shields.io/badge/RestAssured-API--Testing-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-lightgrey)
![Status](https://img.shields.io/badge/Status-Active-success)

---

## 🌐 Overview

This repository contains a **complete API Automation Framework** implemented using:

- **RestAssured** for REST API testing  
- **TestNG** for execution, grouping, assertions  
- **Cucumber (BDD)** for business-readable testing  
- **JDBC + MySQL** for backend validation  
- **Maven** for dependency and build management  

This framework demonstrates **real-world enterprise-level API & Database automation**, suitable for banking, healthtech, edtech, and large-scale microservices.

---

## 🚀 Key Features

### 🔹 API Testing (RestAssured)
- GET / POST / PUT / DELETE coverage  
- JSON response validation  
- Parameterized testing  
- Dynamic payloads  
- Configurable environments (`configs.properties`)

### 🔹 Database Validation (JDBC)
- Execute SQL queries  
- Validate stored data  
- DBUtils reusable methods  
- Metadata validation

### 🔹 Cucumber BDD
- Feature files  
- Step definitions  
- Hooks (before/after)  
- High-level scenarios for readability  

### 🔹 TestNG Execution
- testng.xml suites  
- Parallel execution support  
- Clear reporting  

### 🔹 Utilities
- Global variables  
- Endpoints/constants  
- Reusable methods  
- JSON helpers  
- Config manager  

---

## 📁 Project Structure

src
└── test
├── java
│ ├── com.ayesha.api5 # API test scripts (CRUD)
│ ├── com.ayesha.db # Database/JDBC tests
│ ├── com.demo.api5 # Demo sample APIs
│ ├── com.test.runners # TestNG & Cucumber Runners
│ ├── com.test.steps # Step Definitions (BDD)
│ └── com.test.utils # Utilities & helpers
└── resources
├── configs # Configuration files
├── featurefiles # Cucumber Features
└── test-data # Payloads & JSON files

---

## ▶️ Run Tests

### TestNG
mvn clean test

### Specific Suite
mvn test -DsuiteXmlFile=testng.xml

### Cucumber Tagged Tests
mvn test -Dcucumber.filter.tags="@api"

📊 Reporting

TestNG HTML report

Cucumber JSON & HTML reports

Rich console logs

Error stacktrace visualization

## 🚀 Future Enhancements
- Add Allure reporting
- Add Docker support for containerized test execution
- Add contract testing (Pact)
- Add schema validation with JSON schema
- Add parallel execution via TestNG

👤 Author

Aicha Moustatia
QA Automation Engineer | SDET | API | AI-Assisted Testing

GitHub: https://github.com/Ayesha-sys-QA

LinkedIn: https://linkedin.com/in/aicha-moustatia
