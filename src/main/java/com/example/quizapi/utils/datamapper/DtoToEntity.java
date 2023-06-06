package com.example.quizapi.utils.datamapper;
import com.example.quizapi.bean.Category;
import com.example.quizapi.bean.QuizQuestion;
import com.example.quizapi.bean.QuizQuestionDto;

public class DtoToEntity {

    public static QuizQuestion dtoToQuizQuestion(QuizQuestionDto quizQuestionDto) {
        return QuizQuestion.builder()
                .question(quizQuestionDto.getQuestion())
                .questionId(quizQuestionDto.getId())
                .airdate(quizQuestionDto.getAirdate())
                .answer(quizQuestionDto.getAnswer())
                .createdAt(quizQuestionDto.getCreatedAt())
                .updatedAt(quizQuestionDto.getUpdatedAt())
                .invalid_count(quizQuestionDto.getInvalidCount())
                .questionValue(quizQuestionDto.getValue())
                .game_id(quizQuestionDto.getGameId())
                .category(dtoToCategory(quizQuestionDto))
                .build();
    }
    public static Category dtoToCategory(QuizQuestionDto quizQuestionDto) {
        QuizQuestionDto.CategoryDto categoryDto = quizQuestionDto.getCategory();
        return Category.builder()
                .categoryId(categoryDto.getId())
                .cluesCount(categoryDto.getCluesCount())
                .createdAt(categoryDto.getCreatedAt())
                .updatedAt(categoryDto.getUpdatedAt())
                .title(categoryDto.getTitle())
                .build();
    }
}
