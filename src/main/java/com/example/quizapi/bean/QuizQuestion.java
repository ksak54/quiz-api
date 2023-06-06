package com.example.quizapi.bean;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class QuizQuestion {

    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "question_id", nullable = false)
    private int questionId;

    private String answer;

    private String question;

    @Column(name = "question_value")
    private int questionValue;

    @Column(name = "air_date")
    private ZonedDateTime airdate;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    private int game_id;

    private Integer invalid_count;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Category category;
}

