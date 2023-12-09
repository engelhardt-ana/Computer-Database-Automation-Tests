This test suite is based on Java and Selenium  for testing https://computer-database.gatling.io website.

**Project structure:**
Page Object Model is used to hide the implementation so the framework will not be linear. For building tool I have chosen Maven.

**PageObject package :**
AddEditComputerPage - I have written all xpath/ids and methods for the Add and Edit page.
MainComputerPage - all xpath and methods for the Main page
Also I have used %s for xpath to prevent duplicated code, and it is easier to change this kind of xpath or variable.

**Test package :**
Contains of 18 test grouped by product functionality.
Each test have Test in the name of the class and javadoc to describe the test.

**Test run**
Local installation for Windows:
Install Chrome browser
Check the version of Chrome in Help - About Google Chrome
If the version is above 113 version,
Download the chromedriver.exe that fits your version of Chrome
Change chromedriver.exe from resources in the project
Open IntelliJ, the test you want to run
Use Ctrl+Shift+F10 hot key to run the test.
