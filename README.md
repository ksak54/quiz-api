# quiz-api
Quiz API
Welcome to the API documentation for the Quiz API. This API allows you to fetch random questions, store them in a database, and play the quiz by answering the questions.

Table of Contents
Getting Started
Authentication
Endpoints
Error Handling
Examples
Contributing

Getting Started
To get started using the Quiz API, follow the steps below:

Clone the repository:
shell
Copy code
git clone <repository_url>
Navigate to the project directory:
shell
Copy code
cd quiz-api
Build and run the application using Maven:
shell
Copy code
mvn spring-boot:run
The API will be accessible at http://localhost:8080.

Authentication
The Quiz API does not require authentication.

Endpoints
The following endpoints are available in the Quiz API:

Fetch Random Questions
bash
Copy code
GET /api/questions
This endpoint fetches 5 random questions from the external API endpoint https://jservice.io/api/random and stores them in the database.

Play Quiz
bash
Copy code
GET /api/play
This endpoint returns a random question along with its ID. The response will be in the following format:

json
Copy code
{
  "question_id": 1,
  "question": "Who is the founder of SpaceX?"
}
Answer Question
bash
Copy code
POST /api/next
This endpoint allows you to submit an answer to a question. The payload should be in the following format:

json
Copy code
{
  "question_id": 1,
  "answer": "Elon Musk"
}
The response will contain the correct answer to the question and the next question:

json
Copy code
{
  "correct_answer": "Elon Musk",
  "next_question": {
    "question_id": 2,
    "question": "In which year did World War II end?"
  }
}
Error Handling
The Quiz API handles errors using appropriate HTTP status codes and error messages in the response body. In case of an error, the response will include an error message explaining the issue.

Examples
Here are some examples to help you understand how to use the Quiz API.

Fetch 5 random questions:
bash
Copy code
GET /api/questions
Play the quiz:
bash
Copy code
GET /api/play
Answer a question:
bash
Copy code
POST /api/next

{
  "question_id": 1,
  "answer": "Elon Musk"
}
Contributing
Contributions to the Quiz API are welcome! If you have any ideas, suggestions, or bug reports, please open an issue or submit a pull request.
