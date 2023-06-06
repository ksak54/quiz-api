package com.example.quizapi.service.startup;

import com.example.quizapi.bean.Constants;
import com.example.quizapi.bean.QuizQuestionDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JSApiIntegrationService implements ApiIntegrationService {

    private final RestTemplate restTemplate;

    public JSApiIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<QuizQuestionDto> fetchAndStoreQuizQuestion(int n) {
        List<QuizQuestionDto> questionBank = new ArrayList<>();
        while(n-->0) {
            ResponseEntity<List<QuizQuestionDto>> responseEntity = restTemplate.exchange(
                    Constants.QUESTION,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<QuizQuestionDto>>() {}
            );
            questionBank.add(Objects.requireNonNull(responseEntity.getBody().get(0)));
        }
        return questionBank;
    }
}

