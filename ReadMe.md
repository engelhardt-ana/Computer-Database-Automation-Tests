# Java Selenium Test Suite for Computer Database

## Project Overview
This repository contains a Java and Selenium-based test suite for the [Computer Database](https://computer-database.gatling.io) website. The project adopts the Page Object Model (POM) to ensure a non-linear framework structure. Maven is used as the build tool to manage dependencies and project lifecycle.

## Project Structure

### PageObject Package
- `AddEditComputerPage`: Contains XPath/IDs and methods for Add and Edit pages.
- `MainComputerPage`: Includes XPath and methods for the Main page. Uses `%s` in XPath to avoid code duplication and simplify modifications.

### Test Package
- Contains 18 tests grouped by product functionality.
- Each test class ends with `Test` in its name and includes JavaDoc for description.
- Example tests:
  - `T001verifyComputersPageDefaultStateTest.java`
  - `T002editExistingAceComputerTest.java`
  - `T003addNewComputerAndVerifyComputerExistsInTableTest.java`
  - ... (and others)

## Local Installation and Test Execution (Windows)
1. Install the Chrome browser.
2. Check your Chrome version in 'Help - About Google Chrome'.
3. If Chrome is above version 113, download the appropriate `chromedriver.exe`.
4. Replace `chromedriver.exe` in the project resources.
5. Open IntelliJ and select the test you want to run.
6. Use the Ctrl+Shift+F10 hotkey to execute the test.

## Usage
This test suite is designed to automate the testing of various functionalities on the Computer Database website. It includes tests for adding, editing, deleting computers, and validating UI elements.

## Contributing
Contributions to enhance or extend the test suite are welcome. Please fork the repository and submit pull requests with your proposed changes.

