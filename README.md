# FitPeo Automation Assignment

## **Project Overview**
This project contains automation test scripts developed as part of the FitPeo assignment to validate the functionality of the Revenue Calculator web page. The tests cover the following scenarios:
1. Navigation to the Revenue Calculator page.
2. Validation of slider interactions, including:
   - Moving the slider to a specific value.
   - Updating the slider via the text field.
3. Validation of the "Total Recurring Reimbursement" value when interacting with CPT codes.

The scripts are developed using the following technologies:
- **Selenium WebDriver** for browser automation.
- **TestNG** as the testing framework.
- **Maven** for build and dependency management.

## **Features Tested**
1. **Slider Interactions:**
   - Slider movement and value synchronization with a linked text field.
   - Direct updates of the slider through text field input.
2. **CPT Code Selection:**
   - Automated selection of specific CPT codes.
3. **Validation of Total Recurring Reimbursement:**
   - Ensures the displayed value matches the expected result for given inputs.

## **Prerequisites**
Before setting up and running the project, ensure the following:
- Java Development Kit (JDK) version 8 or higher is installed.
- Maven is installed and configured in the system path.
- Chrome browser is installed, and its version matches the WebDriverManager configuration.
- An IDE (like Eclipse, IntelliJ IDEA, or VS Code) with Maven support.

---

## **Setup Instructions**
Follow these steps to set up and run the project in your local environment:

### **Step 1: Clone the Repository**
Clone the GitHub repository to your local machine using the following command:
```bash
git clone <repository_url>
```

### **Step 2: Open the Project in an IDE**
1. Open your preferred IDE.
2. Import the project as a Maven project:
   - In Eclipse: `File > Import > Maven > Existing Maven Projects`.
   - In IntelliJ IDEA: `File > Open` and select the `pom.xml` file.

### **Step 3: Install Dependencies**
Maven will automatically download the required dependencies defined in the `pom.xml` file. If dependencies are not resolved, run:
```bash
mvn clean install
```

### **Step 4: Run the Tests**
1. Navigate to the `src/test/java` directory.

2. **Run the Tests in Eclipse**:
   - **Option 1**: Locate the `task` test class, right-click on it, and select `Run As > TestNG Test`.
   - **Option 2**: Locate the `testng.xml` file in your project, right-click on it, and select `Run As > TestNG Suite`.

3. **Run the Tests Using Maven**:
   - Open a terminal in the project's root directory (where the `pom.xml` file is located).
   - Execute the following command:
     ```bash
     mvn test
     ```

4. **Run on Other IDEs**:
   - This code is compatible with other popular IDEs like **IntelliJ IDEA** or **VS Code**:
     - Open the project in your preferred IDE.
     - Use the built-in TestNG or Maven plugins to run the tests:
       - In IntelliJ IDEA, you can right-click the `testng.xml` file or the `task` class and select `Run`.
       - In VS Code, ensure the **TestNG** and **Maven** extensions are installed, then execute the tests similarly.

---

## **Project Structure**
The project follows a modular structure for better readability and maintainability:
- **src/main/java:** Contains reusable components and page object classes.
  - `ReusableComponent`: Manages WebDriver initialization and browser setup.
  - `CPTCodePageObject`: Handles interactions with CPT codes.
  - `SliderPageObject`: Handles interactions with the slider and linked text field.
- **src/test/java:** Contains the main test class:
  - `task`: Executes the test scenarios.
- **pom.xml:** Maven configuration file for managing dependencies and plugins.

---

## **Dynamic Web Element Handling**
The scripts are designed to handle dynamic web elements by using:
- Explicit waits to ensure elements are present before interacting.
- Modularized locators for robust and reusable code.

---

## **Testing Environment**
The tests have been developed and validated using:
- **Browser:** Google Chrome (latest version)
- **OS:** Windows 11
- **IDE:** Eclipse IDE 2022-09 (4.25.0)
- **Maven:** 3.8.6

---

## **How to Run Tests in Other Environments**
1. Ensure the required software (JDK, Maven, Chrome, etc.) is installed and configured.
2. Follow the setup instructions outlined above.
3. Update the browser version or WebDriverManager configuration if needed.

---

## **Contact Information**
For any issues or clarifications, you can reach out to:
- **Tester:** AKASH PRASAD MONDAL
- **Email:** akashmondal121@gmail.com
- **LinkedIn:** (https://www.linkedin.com/in/apm010/)
---
