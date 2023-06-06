package com.example.quizapi.bean;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
public class QuizQuestion {

    @Id
    private int id;

    @Column(name = "question_id", nullable = false)
    private int questionId;

    private String answer;

    private String question;

    @Column(name = "question_value")
    private int questionValue;

    private LocalDateTime airdate;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @Column(name = "category_id")
    private int categoryId;

    private int game_id;

    private Integer invalid_count;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;
}

