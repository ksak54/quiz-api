package com.example.quizapi.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"question_id", "question"})
public class QuestionResponse {

    @JsonProperty("question_id")
    private int questionId;

    private String question;
}

