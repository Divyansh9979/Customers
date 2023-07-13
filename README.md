# Customers - Java Spring Boot Project

![Java](https://img.shields.io/badge/Java-11-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.2-green)
![MongoDB](https://img.shields.io/badge/MongoDB-4.4.7-orange)
![Gradle](https://img.shields.io/badge/Gradle-7.0.2-purple)

Welcome to the **Customers** project! This is a Java Spring Boot application developed using MongoDB as the database. The main functionality of this project is to manage customer data by providing endpoints to get a list of all customers, create a new customer, and search for a specific customer using a path variable.

## Prerequisites

Before running this project, make sure you have the following installed:

- Java 11
- MongoDB 4.4.7
- Gradle 7.0.2

## Getting Started

To get started with the **Customers** project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/customers.git
   ```

2. Navigate to the project directory:

   ```bash
   cd customers
   ```

3. Build the application using Gradle:

   ```bash
   gradle build
   ```

4. Run the application:

   ```bash
   gradle bootRun
   ```

   The application will start running on `http://localhost:8080`.

## API Endpoints

The following API endpoints are available in this project:

### Get all customers

Retrieves a list of all customers.

- Method: GET
- URL: `/getAllCustomers`
- Response: JSON array of customers

### Create a new customer

Creates a new customer with the provided data.

- Method: POST
- URL: `/postCustomers`
- Request body: JSON object containing customer data
- Response: JSON object of the created customer

### Search for a customer

Searches for a customer based on the input text provided as a path variable.

- Method: GET
- URL: `/getCustomers/{text}`
- Path variable: `input` - the text to search for
- Response: JSON array of matching customers

Make sure to replace `{text}` in the URL with the actual text you want to search for.

## Sample Requests and Responses

Here are some sample requests and responses for the API endpoints:

### Get all customers

- Request:

  ```bash
  GET /getAllCustomers
  ```

- Response:

  ```json
  [
    {
        "username": "fmiller",
        "name": "Elizabeth Ray",
        "address": "9286 Bethany Glens\nVasqueztown, CO 22939",
        "birthDate": null,
        "email": "arroyocolton@gmail.com",
        "active": true,
        "accounts": [
            371138,
            324287,
            276528,
            332179,
            422649,
            387979
        ],
        "tier_and_details": {
            "id": null,
            "tier": null,
            "active": false,
            "benefits": null
        }
    },
    {
        "username": "valenciajennifer",
        "name": "Lindsay Cowan",
        "address": "Unit 1047 Box 4089\nDPO AA 57348",
        "birthDate": null,
        "email": "cooperalexis@hotmail.com",
        "active": false,
        "accounts": [
            116508
        ],
        "tier_and_details": {
            "id": null,
            "tier": null,
            "active": false,
            "benefits": null
        }
    }
  ]
  ```

### Create a new customer

- Request:

  ```bash
  POST /postCustomers
  Content-Type: application/json

  {
  "id":null,
  "username":"abc",
  "name":"abcdefghi",
  "address":"jkl",
  "birthDate":"2023-07-12T02:20:31.000+00:00",
  "email":"abc@gmail.com",
  "active":true,
  "accounts":null,
  "tier_and_details":null
  }
  ```

- Response:

  ```json
  {
    "username": "abc",
    "name": "abcdefghi",
    "address": "jkl",
    "birthDate": "2023-07-12T02:20:31.000+00:00",
    "email": "abcn@gmail.com",
    "active": true,
    "accounts": null,
    "tier_and_details": null
  }
  ```

### Search for a customer

- Request:

  ```bash
  GET /getCustomers/{text}
  ```

- Response:

  ```json
  [
    {
    "username": "abc",
    "name": "abcdefghi",
    "address": "jkl",
    "birthDate": "2023-07-12T02:20:31.000+00:00",
    "email": "abcn@gmail.com",
    "active": true,
    "accounts": null,
    "tier_and_details": null
    }
  ]
  ```

Feel free to modify the requests and explore other functionalities of the **Customers** project.

## Conclusion

The **Customers** project provides a Java Spring Boot application with MongoDB integration for managing customer data. Use the provided API endpoints to interact with the application and perform operations such as retrieving all customers, creating new customers, and searching for specific customers based on the input text.

If you have any questions or feedback, please don't hesitate to reach out. Happy coding!
