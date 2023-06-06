# Quiz API

This is a Spring Boot REST API that allows you to fetch random questions, store them in a database, and play the quiz by answering the questions.

## Table of Contents
- [Getting Started](#getting-started)
- [Authentication](#authentication)
- [Endpoints](#endpoints)
- [Error Handling](#error-handling)
- [Examples](#examples)
- [Contributing](#contributing)

## Getting Started

To get started with the Quiz API, follow the instructions below:

1. Clone the repository.
2. Build the project using Maven: `mvn clean install`.
3. Run the application: `mvn spring-boot:run`.
4. The API will be accessible at `http://localhost:8081`.

## Authentication

The Quiz API does not require authentication. All endpoints are accessible without authentication.

## Endpoints

The Quiz API provides the following endpoints:

- `GET /play`: Fetches a question along with its ID. Returns the following response:
    ```
    {
        "question_id": <question id>,
        "question": <question text>
    }
    ```

- `POST /next`: Submits an answer for a question. The payload should be in the following format:
    ```
    {
        "question_id": <id>,
        "answer": <answer>
    }
    ```
  Returns the following response:
    ```
    {
        "correct_answer": <correct answer to question>,
        "next_question": {
            "question_id": <question id>,
            "question": <question text>
        }
    }
    ```

## Error Handling

The Quiz API handles various error scenarios and returns appropriate error responses. The error responses follow the standard HTTP status codes and include a descriptive error message.

## Examples

Here are some examples to help you understand how to use the Quiz API.

1. Fetch 5 random questions:

```
GET /api/questions
```

2. Play the quiz:

```
GET /api/play
```

3. Answer a question:

```
POST /api/next

{
  "question_id": 1,
  "answer": "Elon Musk"
}
```

## SQL Schema

The following SQL schema is used to create the necessary tables for storing the questions and categories in the database:

```sql
CREATE TABLE IF NOT EXISTS categories (
    id INT PRIMARY KEY,
    category_id INT,
    title VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    clues_count INT
);

CREATE TABLE IF NOT EXISTS questions (
    id INT PRIMARY KEY,
    question_id INT NOT NULL,
    answer VARCHAR(255),
    question VARCHAR(255),
    question_value INT,
    air_date TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    category_id INT,
    game_id INT,
    invalid_count INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
```

Please make sure to configure your PostgreSQL database connection details accordingly in the application.properties file.

## Dependencies

The Quiz API uses the following dependencies, defined in the `pom.xml` file:

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter JDBC
- H2 Database
- Lombok
- Spring Boot Starter Test
- Spring Boot Starter Validation

## Contributing

Contributions to the Quiz API are welcome! If you find a bug, have an improvement suggestion, or want to add a new feature, please open an issue or submit a pull request.


---

Feel free to modify this README according to your project's specific requirements and add any additional sections or details as needed.
