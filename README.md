API Testing Framework

Java | RestAssured | TestNG | Cucumber | JDBC | Maven
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

📁 Project Structure
src
 └── test
     ├── java
     │   ├── com.ayesha.api5         # API test scripts
     │   ├── com.ayesha.db           # DB testing
     │   ├── com.demo.api5           # Sample API tests
     │   ├── com.test.runners        # TestNG & Cucumber runners
     │   ├── com.test.steps          # BDD step definitions
     │   └── com.test.utils          # Shared utilities
     └── resources
         ├── configs                 # Configuration files
         ├── featurefiles            # Cucumber feature files
         └── test-data               # Payloads / Expected results



▶️ Run Tests Locally
TestNG
mvn clean test


Run specific suite
mvn test -DsuiteXmlFile=testng.xml

Cucumber
mvn test -Dcucumber.filter.tags="@api"


📊 Reporting

TestNG HTML report

Cucumber JSON & HTML reports

Rich console logs

Error stacktrace visualization

🧩 Future Improvements

This section shows your senior-level thinking.

Add Allure Reports

Add schema validation with JSON Schema

Add Docker container for test execution

Add parallel execution with Selenium Grid (for UI extension)

Integrate ChatGPT/DeepSeek for AI-assisted test case generation

Add API contract testing (Postman/Newman or Pact)

👤 Author

Aicha Moustatia
QA Automation Engineer | SDET | API | AI-Assisted Testing

GitHub: https://github.com/Ayesha-sys-QA

LinkedIn: https://linkedin.com/in/aicha-moustatia
