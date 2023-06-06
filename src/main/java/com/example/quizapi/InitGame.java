package com.example.quizapi;

import com.example.quizapi.bean.QuizQuestionListDto;
import com.example.quizapi.service.startup.ApiIntegrationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitGame {

    public InitGame(ApiIntegrationService apiIntegrationService) {
        this.apiIntegrationService = apiIntegrationService;
    }

    private final ApiIntegrationService apiIntegrationService;


    public void initGame() {
        List<QuizQuestionListDto.QuizQuestionDto> dto = apiIntegrationService.fetchAndStoreQuizQuestion(5);

    }


}
