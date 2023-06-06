# Quiz API

Welcome to the API documentation for the Quiz API. This API allows you to fetch random questions, store them in a database, and play the quiz by answering the questions.

## Table of Contents
- [Getting Started](#getting-started)
- [Authentication](#authentication)
- [Endpoints](#endpoints)
- [Error Handling](#error-handling)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

To get started using the Quiz API, follow the steps below:

1. Clone the repository:

```shell
git clone <repository_url>
```

2. Navigate to the project directory:

```shell
cd quiz-api
```

3. Build and run the application using Maven:

```shell
mvn spring-boot:run
```

The API will be accessible at `http://localhost:8080`.

## Authentication

The Quiz API does not require authentication.

## Endpoints

The following endpoints are available in the Quiz API:

### Fetch Random Questions

```
GET /api/questions
```

This endpoint fetches 5 random questions from the external API endpoint `https://jservice.io/api/random` and stores them in the database.

### Play Quiz

```
GET /api/play
```

This endpoint returns a random question along with its ID. The response will be in the following format:

```json
{
  "question_id": 1,
  "question": "Who is the founder of SpaceX?"
}
```

### Answer Question

```
POST /api/next
```

This endpoint allows you to submit an answer to a question. The payload should be in the following format:

```json
{
  "question_id": 1,
  "answer": "Elon Musk"
}
```

The response will contain the correct answer to the question and the next question:

```json
{
  "correct_answer": "Elon Musk",
  "next_question": {
    "question_id": 2,
    "question": "In which year did World War II end?"
  }
}
```

## Error Handling

The Quiz API handles errors using appropriate HTTP status codes and error messages in the response body. In case of an error, the response will include an error message explaining the issue.

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

## Contributing

Contributions to the Quiz API are welcome! If you have any ideas, suggestions, or bug reports, please open an issue or submit a pull request.

## License

The Quiz API is released under the [MIT License](LICENSE). Feel free to use, modify, and distribute it as per the terms of the license.
