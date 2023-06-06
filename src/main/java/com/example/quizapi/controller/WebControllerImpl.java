package com.example.quizapi.controller;

import com.example.quizapi.bean.requestbody.NextRequestDto;
import com.example.quizapi.bean.response.NextQuestionResponse;
import com.example.quizapi.bean.response.QuestionResponse;
import com.example.quizapi.service.QuestionServiceImpl;
import com.example.quizapi.service.startup.ApiIntegrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@Slf4j
public class WebControllerImpl implements WebController {

    private final QuestionServiceImpl questionService;
    private final ApiIntegrationService apiIntegrationService;

    public WebControllerImpl(QuestionServiceImpl questionService, ApiIntegrationService apiIntegrationService) {
        this.questionService = questionService;
        this.apiIntegrationService = apiIntegrationService;
    }

    @Override
    @GetMapping("/play")
    public ResponseEntity<QuestionResponse> startPlaying() {
        log.info("hitting /play endpoint");
        Optional<QuestionResponse> question = questionService.startPlaying();
        return question.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Override
    @PostMapping("/next")
    public ResponseEntity<NextQuestionResponse> next(@Valid @RequestBody NextRequestDto nextBody) {
        log.info("hitting /next endpoint with payload {}", nextBody);
        Optional<NextQuestionResponse> nextQuestionResponse = questionService.next(nextBody.getQuestionId());
        return nextQuestionResponse.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
