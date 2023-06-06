package com.example.quizapi.service.startup;

import com.example.quizapi.bean.Category;
import com.example.quizapi.bean.Constants;
import com.example.quizapi.bean.QuizQuestion;
import com.example.quizapi.bean.QuizQuestionListDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
public class ApiIntegrationService {

    private final RestTemplate restTemplate;

    public ApiIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<QuizQuestionListDto.QuizQuestionDto> fetchAndStoreQuizQuestion(int n) {
        List<QuizQuestionListDto.QuizQuestionDto> questionBank = new ArrayList<>();
        while(n-->0) {
            ResponseEntity<List<QuizQuestionListDto.QuizQuestionDto>> responseEntity = restTemplate.exchange(
                    Constants.QUESTION,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<QuizQuestionListDto.QuizQuestionDto>>() {}
            );
            questionBank.add(Objects.requireNonNull(responseEntity.getBody()).get(0));
        }
        return questionBank;
    }
}

