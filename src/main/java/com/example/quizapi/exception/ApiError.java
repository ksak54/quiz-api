package com.example.quizapi.exception;

public class ApiError {
    String message;
    String message2;
    int m;

    public ApiError(String message, String message2, int m) {
        this.message = message;
        this.message2 = message2;
        this.m = m;
    }
}
