package com.example.quizapi.controller;

import com.example.quizapi.bean.requestbody.NextRequestDto;
import com.example.quizapi.bean.response.NextQuestionResponse;
import com.example.quizapi.bean.response.QuestionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface WebController {

    @GetMapping("/play")
    ResponseEntity<QuestionResponse> startPlaying();

    @PostMapping("/next")
    ResponseEntity<NextQuestionResponse> next(@Valid @RequestBody NextRequestDto nextBody);
}
