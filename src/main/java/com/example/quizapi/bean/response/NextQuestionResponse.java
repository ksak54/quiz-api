package com.example.quizapi.bean.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"correct_answer", "next_question"})
public class NextQuestionResponse {

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty("next_question")
    private QuestionResponse nextQuestion;
}

