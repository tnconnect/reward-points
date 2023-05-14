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
   The password will be shared to customer or other systems by secured methods(not in current scope).
4. The requester need to pass the user name and password to authenticate and obtain the short live JWT token generated using HS256 Algorithm.
5. The curl command to get the JWT api access token is as follows -
   curl -X POST https://127.0.0.1:8443/authenticate -k -H "Content-Type: application/json" -d "{\"userName\": \"John\", \"password\": \"asdfg@2\"}"
   The username is John 
   The password is asdfg@2
6. After sucessfully authentication and getting the access token in step 5 the following curl command is used to get the rewards between from and to dates.

curl -k -H "Authorization: Bearer <ACCESS TOKEN FROM STEP 5>" "Content-Type: application/json" https://127.0.0.1:8443/rewards/v1/102/04-01-2022/07-01-2022

Example-
curl -k -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huIiwiZXhwIjoxNjg0MDMxMTE4LCJpYXQiOjE2ODQwMjkzMTh9.jj8m6bQ0s2J5D7O9zoSZpY2DqOR7861GW27iKECIJqg" "Content-Type: application/json" https://127.0.0.1:8443/rewards/v1/102/04-01-2022/07-01-2022

The url is https://127.0.0.1:8443/rewards/v1/102/04-01-2022/07-01-2022 
where customer id = 102, from date = 04-01-2022 and end date = 07-01-2022 (the date format MM-DD-YYYY) 

The response json is as follows and rewardDetailList contains monthwise reward points during the given dates.
{
  "customerId": 102,
  "totalRewards": 115,
  "rewardDetailList": [
    {
      "startDate": "2022-04-01",
      "endDate": "2022-04-30",
      "rewardPoints": 39
    },
    {
      "startDate": "2022-05-01",
      "endDate": "2022-05-31",
      "rewardPoints": 0
    },
    {
      "startDate": "2022-06-01",
      "endDate": "2022-06-30",
      "rewardPoints": 76
    },
    {
      "startDate": "2022-07-01",
      "endDate": "2022-07-01",
      "rewardPoints": 0
    }
  ]
}

The Key points covered in the projects are as follows
1. The project is build up using Rest Controllers, Services and Repositories with H2 embedded Database. 
    The Java 11 , spring-boot-parent 2.7.10 version, spring-boot-starter-data-jpa, spring-boot-starter-security, io.jsonwebtoken and com.h2databas are used.

2. The rest api is designed considering API security and confidentiality of user data.
 
3. The main controller for rewards api is RewardPointsController.java. The customer id, from date , to date is required to pass to the api.

4. The https is configured and a self sign certificate is created using keytool and stored in the resource folder.
   But in the production that will be stored in the secret stores.
   The key is generated using keytool and PKCS12 encoding. 
   
5. The Spring Security is used to force the main rest api to go through authentication mechanism to access the api.
  The SecurityConfig.java enabled  @EnableWebSecurity to filter the api which needs the authentication process. 

6. The resource folder contains the data.sql and schema.sql files to create data in H2 Database.
    The url for H2 Database https://127.0.0.1:8443/h2-console and password is sa
    The application.properties file contains the database properties information.
    
7. The Authentication Controller has the authenticate api using POST method to obtain the temporary accesstoken. The request will contain username and password.

8. The Main logic to calcualte the rewards is in Service implementation class.
9. The response reward points will be validated by login to the embedded H2 database.
 
   



