# reward-points
The application is developed using Spring boot and Java which provides Reward Points data to the Customers.

The steps to build and run the project are as follows.
1. Checkout the project from github and configured it in the Integrated Development Environment.
2. The project requires Java 11 version.
3. Use Maven command 'mvn clean install' to build the project using a IDE. Then run the project as spring boot application.
4. The project has embedded h2 database which starts with application and loads the seed data for the application.

Steps to test the application
1. Use any rest service testing tool like postman or we can use curl command in windows or linux system.
2. The Rest api only accepts the https requests.
3. At first get an temporary accces token using the customer name and password. 
   The password will be shared to customer or other systems by secured methods.
