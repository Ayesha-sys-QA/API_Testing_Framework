API Testing Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![TestNG](https://img.shields.io/badge/TestNG-Framework-blue)
![RestAssured](https://img.shields.io/badge/RestAssured-API--Testing-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-lightgrey)
![Status](https://img.shields.io/badge/Status-Active-success)

Overview

This repository contains a complete API Automation Framework with the following capabilities:

✔️ Automated API test scripts (GET, POST, PUT, DELETE)
✔️ BDD testing with Cucumber
✔️ Test execution & grouping with TestNG
✔️ SQL database validation (JDBC + MySQL)
✔️ Reusable utilities & configuration management
✔️ Easily extendable for microservices or enterprise platforms

Designed to reflect real-world QA Automation engineer responsibilities seen in banking, healthcare, SaaS, and e-government systems.

🔥 Features
🔹 API Testing (RestAssured)

RESTful API test coverage

Response/Schema validation

Token-based authentication

Environment variables from configs.properties

🔹 Cucumber BDD Layer

Feature files for high-level scenarios

Reusable steps

Hooks for setup/teardown

Human-readable documentation for business teams

🔹 TestNG Execution

Parallel testing

XML suite support

Logging + rich HTML results

🔹 Database Testing (JDBC)

Execute SQL queries

Data consistency validation

DBUtils helper for reusability

🔹 Utility Layer

Payload builders

Endpoints/constants

Global variables

Config reader

Token generator

## 📁 Project Structure

src
└── test
    ├── java
    │ ├── com.ayesha.api5 # API Tests
    │ ├── com.ayesha.db # SQL/JDBC Tests
    │ ├── com.test.runners # Runners
    │ ├── com.test.steps # BDD Steps
    │ └── com.test.utils # Utilities
    └── resources
├── configs
├── featurefiles
└── test-data

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
