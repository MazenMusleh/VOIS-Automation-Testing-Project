# 🧪 VOIS Automation Testing Project

![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-orange)
![TestNG](https://img.shields.io/badge/TestNG-Testing%20Framework-brightgreen)
![Allure](https://img.shields.io/badge/Allure-Reporting-purple)
![RestAssured](https://img.shields.io/badge/REST--Assured-API%20Testing-yellow)

---

## 📘 Overview

This project automates both **UI** and **API** test cases for:

- 💲 **Amazon Website Scenarios**
- 🚌 **KSRTC Bus Booking Portal**
- 🌐 **JSONPlaceholder API Testing**

It’s built using **Java 21**, **Maven**, **TestNG**, **Selenium WebDriver**, and **REST Assured**, following the **Page Object Model (POM)** design pattern to ensure scalability, maintainability, and clean separation of concerns.

---

## ✨ Key Features & Best Practices

- **Hybrid Framework:** Combines Web UI and API testing under one Maven project.  
- **Page Object Model (POM):** Each page has a dedicated class to encapsulate UI elements and actions.  
- **Reusable Utilities:** Shared helpers for waits, assertions, configurations, logging, and screenshots.  
- **Allure Reporting:** Generates interactive HTML reports automatically after test execution.  
- **Dynamic Data with Faker:** Avoids hardcoded data for better coverage.  
- **Logs:** Detailed logs stored under `/logs/VOIS_Automation_Task.log` for debugging.

---

## 🔹 Technology Stack (ROI Justification)

| Tool | Purpose | ROI |
|------|----------|------|
| **Java 21** | Core programming language | Stable, enterprise-grade |
| **Maven** | Dependency & build management | Simplifies builds & CI/CD |
| **TestNG** | Testing framework | Enables flexible test control & parallel runs |
| **Selenium WebDriver** | UI automation | Cross-browser web testing |
| **REST Assured** | API automation | Quick validation for REST endpoints |
| **Allure Report** | Reporting | Interactive reports with logs & screenshots |
| **Faker Library** | Data generation | Randomized data, zero hardcoding |

---

## 📂 Project Structure

```bash
VOIS_Automation_Task/
│   pom.xml
│   README.md
│   Task_Manual_TestCases.xlsx
│   Task_Run_video.mp4
│   
├───allure-report
│       index.html
│       
├───allure-results
│       *.json
│       
├───logs
│       VOIS_Automation_Task.log
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───APIs
│   │   │   │   ├───POJO_Models
│   │   │   │   │       Album_Response.java
│   │   │   │   │       PostComment_Response.java
│   │   │   │   │       Post_Payload_Response.java
│   │   │   │   │       Todo_Response.java
│   │   │   │   │
│   │   │   │   └───Specifications
│   │   │   │           RequestSpec.java
│   │   │   │
│   │   │   ├───GUIs
│   │   │   │   ├───Base
│   │   │   │   │       DriverFactory.java
│   │   │   │   │       DriverManager.java
│   │   │   │   │
│   │   │   │   └───pages
│   │   │   │       ├───AmazonPages
│   │   │   │       │       EntryPage.java
│   │   │   │       │       ItemsPage.java
│   │   │   │       │       LeftSideBarPage.java
│   │   │   │       │       MyCartPage.java
│   │   │   │       │       TopBarPage.java
│   │   │   │       │
│   │   │   │       └───KsrtcPages
│   │   │   │               BookingPage.java
│   │   │   │               ChoosingPaymentPage.java
│   │   │   │               HomePage.java
│   │   │   │               PaymentPage.java
│   │   │   │
│   │   │   └───Utilization
│   │   │           ActionsUtils.java
│   │   │           AllureUtils.java
│   │   │           AssertionUtils.java
│   │   │           ConfigManager.java
│   │   │           CSVUtils.java
│   │   │           FakerUtils.java
│   │   │           JavaScriptUtils.java
│   │   │           LogUtils.java
│   │   │           PropertyFileReader.java
│   │   │           ScreenshotsUtils.java
│   │   │           TestListener.java
│   │   │           WaitUtils.java
│   │   │
│   │   └───resources
│   └───test
│       ├───java
│       │   ├───APIs
│       │   │       JsonApiTests.java
│       │   │
│       │   └───GUIs
│       │           AmazonTests.java
│       │           KsrtcTests.java
│       │
│       └───resources
│               configs.properties
│               log4j2.xml
│               search_items.csv
│               testData.properties
│               testng.xml
│
```

---

## ⚙️ Setup & Installation

### ✅ Prerequisites

1. **Install Java 21**
   ```bash
   java -version
   ```

2. **Install Maven**
   - Download from [Apache Maven](https://maven.apache.org/download.cgi)
   - Extract to `C:\Program Files\Apache\Maven`
   - Add `bin` to your System Path
   - Verify:
     ```bash
     mvn -version
     ```

3. **Install Allure Report CLI (Windows)**
   ```bash
   scoop install allure
   allure --version
   ```

---

## ▶️ Running the Tests

### **Option 1 – From IDE**
Right-click `testng.xml` → **Run**.

### **Option 2 – From Command Line**
Run using Maven:
```bash
mvn clean test "-Dsurefire.suiteXmlFiles=src/test/resources/testng.xml"
```

---

## 📊 Reporting

After test execution, results are generated under:
```
allure-results/
```

Generate and open the report automatically:
```bash
allure generate allure-results -o allure-report --clean
allure open allure-report
```

The `TestListener.java` also triggers report generation automatically after tests complete.

---

## 📁 Logs
Execution logs are stored at:
```
logs/VOIS_Automation_Task.log
```

---

## 🧩 Included Test Modules

### 🧠 **API Tests**
- `JsonApiTests.java`
  - Validates GET/POST endpoints for JSONPlaceholder API
  - Includes response code checks, schema validation, and payload assertions.

### 🌐 **UI Tests**
#### Amazon
- `AmazonTests.java`
    - Search for items, apply filters, add to cart, and validate cart count.

#### KSRTC
- `KsrtcTests.java`
    - Complete end-to-end bus ticket booking flow including payment step validations.
