package com.example.quizapi.service;

import com.example.quizapi.bean.response.NextQuestionResponse;
import com.example.quizapi.bean.response.QuestionResponse;

import java.util.Optional;

public interface QuestionService {

    Optional<QuestionResponse> startPlaying();

    Optional<NextQuestionResponse> next(int id);
}
