package com.example.quizapi.bean.requestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class NextRequestDto {

    @JsonProperty("question_id")
    @NotNull(message = "questionId is mandatory")
    private int questionId;

    @JsonProperty("answer")
    @NotBlank(message = "answer is mandatory")
    private String answer;
}

