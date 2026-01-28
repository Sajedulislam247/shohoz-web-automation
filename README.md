# shohoz-web-automation
# Shohoz Automation Project - Playwright Java, TestNG and Allure

This repository contains an automated test suite for a web application, developed using **Playwright with Java** and the **TestNG** framework. It follows the **Page Object Model (POM)** design pattern for scalability and uses **Allure Reports** for comprehensive, interactive reporting.

---

### 1. Technology Stack

| Technology | Purpose |
| :--- | :--- |
| **Java** | Primary programming language |
| **Playwright** | Core automation library for browser interaction |
| **TestNG** | Testing framework for execution and structure |
| **Allure Reports** | Interactive reporting tool for detailed test analysis |
| **Gradle** | Build automation and dependency management |
| **Test Data File** | Stores dynamic test data (`testdata.properties`) |

### 2. Prerequisites

Before running the tests, ensure you have the following installed:

* **Java Development Kit (JDK):** Version 11 or higher.
* **Allure Command Line Tool:** Necessary to generate and view the reports. Install it via a package manager (like Scoop or Homebrew) or download the binary from the [Allure Framework website](https://docs.qameta.io/allure/latest/manual/install/).

### 3. Setup and Installation

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sajedulislam247/shohoz-web-automation.git
    cd src
    ```

2.  **Download Dependencies:**
    Use the included Gradle wrapper to download all required libraries, including Playwright and Allure dependencies:
    ```bash
    # On Linux/macOS
    ./gradlew build

    # On Windows
    gradlew.bat build
    ```

3.  **Configure Test Data:**
    All dynamic test parameters (like credentials, URLs, and search queries) are managed in the properties file. Update the values in `src/main/resources/testdata.properties` before execution.

### 4. Project Structure (Page Object Model)

The project adheres to the POM pattern, separating test logic from page element interaction:

| Folder/File | Description |
| :--- | :--- |
| `src/main/java/.../page` | Contains **Page Object** classes (`HomePage.java`, , etc.) that hold elements and methods specific to a web page. |
| `src/test/java/.../web` | Contains the actual **Test Classes** that use TestNG annotations to define the workflows. |
| `src/main/resources` | Stores configuration (`log4j2.xml`) and external data (`testdata.properties`). |
| `build.gradle` | Configuration file that manages dependencies and Allure integration. |

---

## Test Execution and Reporting

### 5. Test Scenarios Covered

1.Navigate to: https://www.shohoz.com/air-tickets
2. Click One way radio button
3. Select Journey date as tomorrow
4. Click Modify Search.

### 6. Running the Tests

Execute the tests and generate the raw Allure results using the Gradle wrapper:

```bash
# Runs tests and generates raw JSON/TXT files in the build/allure-results directory.
./gradlew clean test
```


### 7. Generating and Viewing Allure Reports
After the tests are complete, use the Allure command line tool to process the results and open the interactive HTML report in your browser:
AS FOR GRADLE v9.0.0 or higher
Bash
```
iwr -useb get.scoop.sh | iex

scoop install allure

allure generate allure-results -o allure-report --clean

allure open allure-report

# Generates the report and serves it on a local web server (e.g., [http://0.0.0.0](http://0.0.0.0):port)

```

<img width="1365" height="602" alt="image" src="https://github.com/user-attachments/assets/e6d9cb63-788a-43b0-9678-f35bc074ac82" />



