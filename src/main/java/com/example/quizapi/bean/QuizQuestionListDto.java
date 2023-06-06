package com.example.quizapi.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class QuizQuestionListDto {

    private List<QuizQuestionDto> questions;

    @Data
    public static class QuizQuestionDto {

        private int id;

        private String answer;

        private String question;

        private int value;

        private ZonedDateTime airdate;

        @JsonProperty("created_at")
        private ZonedDateTime createdAt;

        @JsonProperty("updated_at")
        private ZonedDateTime updatedAt;

        @JsonProperty("category_id")
        private int categoryId;

        @JsonProperty("game_id")
        private int gameId;

        @JsonProperty("invalid_count")
        private Integer invalidCount;

        private CategoryDto category;
    }

    @Data
    public static class CategoryDto {

        private int id;

        private String title;

        @JsonProperty("created_at")
        private ZonedDateTime createdAt;

        @JsonProperty("updated_at")
        private ZonedDateTime updatedAt;

        @JsonProperty("clues_count")
        private int cluesCount;
    }
}