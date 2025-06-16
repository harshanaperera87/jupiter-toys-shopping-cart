
# Planit Automation Assessment

This project is a basic Selenium test automation framework built using **Java**, **Selenium WebDriver**, and **TestNG**. It is designed for running tests in the **Chrome browser**, using input data from an Excel file. The framework supports both individual and grouped test execution, and generates detailed logs and reports for analysis.

## Test Framework

- **Framework:** TestNG
- **Browser:** Chrome (via ChromeDriver)
- **Test Data Source:** `TestData.xlsx` located in the `testData` folder

- **Execution Options:**
    - Run test classes individually
    - Run all tests together using `master.xml`

- **Logging:** Generated in the `logs` directory
- **Reports:** 'Extent reports' are stored in the `reports/` directory

##  How to Run the Tests

###  Prerequisites
- Java 17 or above
- Maven and TestNG plugin in your IDE (e.g., IntelliJ)
- Chrome browser installed

1. Run All Tests Using `master.xml`
   - You can run all tests together via the `master.xml`
   - Go into 'testSuite' → Right-click on master.xml → Run as TestNG Suite


2. Run Individual Test Classes
   - Open any test class like TC01_ValidateContactPageErrorMsgs and run it directly from your IDE.

## Selenium Tests Continuous Integration

This repository is configured with a GitHub Actions workflow that runs Selenium tests automatically.

- The tests are triggered on every push to the main branch.
- The workflow executes the Selenium test suite using a headless browser.
- Test results can be viewed directly in the GitHub Actions tab.

## Logs & Reports
- Logs: Generated in the 'logs' folder (e.g., Planit.log)
- Reports: After test execution, open the HTML report located in the 'reports' folder.

## Test Data File
- All input data used for the tests is stored in 'testData' folder (TestData.xlsx)

## Cleanup
- WebDriver is properly closed using @AfterClass methods in each test class to ensure no browser instances are left open after tests run.


