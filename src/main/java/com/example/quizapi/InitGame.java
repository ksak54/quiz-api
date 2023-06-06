package com.example.quizapi;

import com.example.quizapi.bean.Category;
import com.example.quizapi.bean.QuizQuestion;
import com.example.quizapi.bean.QuizQuestionDto;
import com.example.quizapi.repository.CategoryRepository;
import com.example.quizapi.repository.QuestionRepository;
import com.example.quizapi.service.startup.ApiIntegrationService;
import com.example.quizapi.utils.datamapper.DtoToEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitGame {

    private final ApiIntegrationService apiIntegrationService;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    public InitGame(ApiIntegrationService apiIntegrationService, QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.apiIntegrationService = apiIntegrationService;
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    public void initGame() {
        List<QuizQuestionDto> dto = apiIntegrationService.fetchAndStoreQuizQuestion(5);
        List<QuizQuestion> questionList = dto.stream().map(DtoToEntity::dtoToQuizQuestion).collect(Collectors.toList());
        List<Category> categoryList = dto.stream().map(DtoToEntity::dtoToCategory).collect(Collectors.toList());
        questionRepository.saveAll(questionList);
    }
}
