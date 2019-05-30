**HW1**

Check elements in HomePage https://epam.github.io/JDI/
Two classes HomePageHardAsserts and HomePageSoftAsserts were created.
For hard and Soft asserts respectively.

Chrome version 74.0.3729.157

Chromedriver.exe uploaded to git

**HW2**

HW2 contains 3 packages. For exercise 1, exercise - 2, exercise - 3 respectively.
And 3 testng.xml files.
testngRegression.xml and testngSmoke.xml for exercise 2. To run all "Regression" tests and "Smoke" tests. Both of configs run in parallel by methods mode and with 3 threads.
testngTestAnnotation.xml for test for exercise 3


**HW1, HW2, HW3 updates 22.05.2019**

1. Code was refactored based on IDEA shortcuts
2. HW1: 2 For loops and 2 lists were added for searching items in left-hand section and for text under 4 images.
3. gitignore file was created and commit to git. IDEA specific files were added to the file.
4. HW2: files were updated based on HW1 changes.
5. HW3: files were updated based on HW1 changes. To find items in left-hand menu xpath search by text was used. For text under 4 images css and for loop were used.


**HW1 updates 27.05.2019**
Loops for searching items in left-hand section and for text under 4 images were updated


**HW3 updates for 28.05.2019**
1. One method was created for each step 6,7,8
2. Instead of working with PO elements directly methods are used
3. Config.properties file and enums were added to remove all hardcoded values in test


**HW3 and HW4 updates 30.05.2019**
1. JAVA version 1.8. pom.xml changed for the JAVA version
2. Configuration file was implement via Owner library. Configuration file contains only configuration paramenter: login, password, url.
3. A separated class with constants was created for other values from HomePage.
4. Constants in Enum were renamed.
5. Methods in PO were renamed.
6. Parameters are directly called in methods in PO.
7. Template was used for logs generation.
