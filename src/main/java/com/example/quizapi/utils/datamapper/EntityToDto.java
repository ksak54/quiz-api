package com.example.quizapi.utils.datamapper;

import com.example.quizapi.bean.QuizQuestion;
import com.example.quizapi.bean.response.NextQuestionResponse;
import com.example.quizapi.bean.response.QuestionResponse;

public class EntityToDto {

    public static QuestionResponse entityToQuestionResponse(QuizQuestion quizQuestion) {
        return QuestionResponse
                .builder()
                .question(quizQuestion.getQuestion())
                .questionId(quizQuestion.getQuestionId())
                .build();
    }
}
