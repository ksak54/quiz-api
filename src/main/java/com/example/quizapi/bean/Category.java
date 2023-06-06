package com.example.quizapi.bean;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    private int id;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    private String title;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "clues_count", nullable = false)
    private int cluesCount;

    @OneToMany(mappedBy = "category")
    private List<QuizQuestion> quizQuestions;
}

