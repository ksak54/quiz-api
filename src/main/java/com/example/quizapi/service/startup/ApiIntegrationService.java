package com.example.quizapi.service.startup;

import com.example.quizapi.bean.QuizQuestionDto;

import java.util.List;

public interface ApiIntegrationService {
    List<QuizQuestionDto> fetchAndStoreQuizQuestion(int n);
}
