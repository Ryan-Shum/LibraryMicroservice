
# Library Management Microservice
This library management project enables users to get the book list, view and update the status of books. 
It consists of 3 microservices: BookService, BorrowingService and EurekaService. 

 - The Book Service manages books and their statuses
 - The Borrowing Service manages the borrowing and returning of books.
 - The Eureka Service is a service registry that allows the other services to communicate with each other.
## Prerequisites
 - Java 17
 - Maven
## Dependencies used
 - Spring Cloud Netflix Eureka Server & Client 
 - Spring Data JPA
 - Open Feign Client
 - H2 Database
 - Lombok
 - Spring Boot Dev Tools

## Running the application
1. Clone the repository: `git clone https://github.com/Ryan-Shum/LibraryMicroservice.git`  
2. Navigate to each service directory (`BookService`, `BorrowingService`, `EurekaService`) and build each application: `mvn clean install`  
3. Run each application: `mvn spring-boot:run`
4. You can also import the project in an IDE like IntelliJ and run each service
5. Go to Eureka Service: `http://localhost:8761` to see if `BookService` and `BorrowingService` instances were successfully registered 
6. Click on each registered instance and test the endpoints with Postman or Insomnia

# API Documentation

This documentation covers the endpoints for the Book Service and the Borrowing Service.

## Book Service

### Get All Books

**URL:** `/books/list`

**Method:** `GET`

**Purpose:** Fetches all books from the book-service.

### Get Book Status

**URL:** `/books/{id}/status`

**Method:** `GET`

**URL Params:**

- **Required:** `id=[Long]`

**Purpose:** Fetches the status of a book in the book-service.

### Update Book Status

**URL:** `/books/{id}/status`

**Method:** `PUT`

**URL Params:**

- **Required:** `id=[Long]`

**Data Params:**

- **Required:** `status=[BookStatus]`

**Purpose:** Updates the status of a book in the book-service.

## Borrowing Service

### Get All Books

**URL:** `/borrow/booklist`

**Method:** `GET`

**Purpose:** Fetches all books from the borrowing-service.

### Borrow a Book

**URL:** `/borrow/book/{bookId}/borrow`

**Method:** `POST`

**URL Params:**

- **Required:** `bookId=[long]`

**Purpose:** Borrows a book from the borrowing-service.

### Return a Book

**URL:** `/borrow/book/{bookId}/return`

**Method:** `POST`

**URL Params:**

- **Required:** `bookId=[long]`

**Purpose:** Returns a book to the borrowing-service.
