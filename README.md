# SalesTest
A spring boot based **Java** app, you can see results in the **console** or **http://localhost:8080** in your browser, it uses **Java 17** and **Maven** you can change the default port from **8080** to any other port number in case you have other services using that port such as Tomcat, all by modifying **application.properties** file under resources folder.

## 1- Simple class diagram
![Browser](https://raw.githubusercontent.com/rasmi-aw/SalesTest/master/docs/sales_test_class_diagram.png)

## 2-how to run the app ?
running the app can be done in two ways, first: using ide (ex: intellij-idea) run button, or using command line to build it using **Maven** then run it.  
`mvn clean`  
`mvn package`  
`java -jar target/SalesTest-1.0.0.war`

## 3-Where to see results ?
### 3.1 in console:
![Console](https://raw.githubusercontent.com/rasmi-aw/SalesTest/master/docs/console.png)
### 3.2 in browser:
![Browser](https://raw.githubusercontent.com/rasmi-aw/SalesTest/master/docs/browser.png)

## 4-Where is the Code ?
the code is put under the main folder

## 5-Where are the tests ?
the tests are put under test folder

## 6-Change test data ?
the data used in this application is passed through the FakeDataProvider, to separate the business logic from data layer, all stored in **data.json** file, if you want to try with other type of data just change that file content, don't forget to edit results in test classes.

