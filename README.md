# Loqo Assignment

This project is a Spring Boot application designed to manage and filter products. It includes a RESTful API endpoint for retrieving products with various filters and sorting options.

## Project Structure

- **Controller:** `ProductController` handles HTTP requests and interacts with the `ProductService` to retrieve filtered and sorted product data.
- **Service:** `ProductService` provides business logic for filtering and sorting products.
- **Model:** `Product` represents the product entity.
- **Configuration:** Maven is used for project management and dependency handling.

## Features

- **Filter Products** by category, minimum price, maximum price, and stock status.
- **Sort Products** by a specified field (`price` by default) and order (`asc` or `desc`).

## API Endpoint

### Get Products

**URL:** `http://localhost:8888/products`

**Method:** `GET`

**Parameters:**

- `category` (optional) - Filter products by category.
- `minPrice` (optional) - Filter products with a price greater than or equal to this value.
- `maxPrice` (optional) - Filter products with a price less than or equal to this value.
- `inStock` (optional) - Filter products based on stock availability (true or false).
- `sortField` (optional, default: "price") - Field to sort the products by.
- `sortOrder` (optional, default: "asc") - Order to sort the products in ("asc" or "desc").

## Setup

1. **Clone the repository**:

    ```bash
    git clone <https://github.com/Virendrakumardwivedi/LoqoAi-assignment>
    ```

2. **Build and Run**:

    ```bash
    mvn spring-boot:run


3. **API Endpoints**:
```http
GET http://localhost:8888/products?category=Electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=desc
```

4. **Example Response:**
```[
    {
        "id": 1,
        "name": "Smartphone",
        "category": "Electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2023-01-15T06:30:00.000+00:00"
    },
    {
        "id": 2,
        "name": "Laptop",
        "category": "Electronics",
        "price": 899.99,
        "inStock": true,
        "rating": 4.7,
        "createdAt": "2023-03-20T03:00:00.000+00:00"
    }
]
```
## Dependencies:**

- Spring Boot 2.7.5
- Spring Data JPA
- Spring Web
- MySQL Connector
- Lombok (for reducing boilerplate code)
- Mockito (for testing)

## Testing
The application includes unit and integration tests to ensure the functionality of the service and controller layers.
```
mvn test
```
## Demo
![Screenshot 2024-07-20 134819](https://github.com/user-attachments/assets/0b23ec1d-20ce-4a81-bb6a-257cd384c540)

**Test**
![Screenshot (597)](https://github.com/user-attachments/assets/f1e62fcb-54ac-42b1-aee4-86bc379d09be)

