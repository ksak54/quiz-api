package com.example.quizapi.bean;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Category {
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    private String title;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "clues_count", nullable = false)
    private int cluesCount;

    @OneToMany(mappedBy = "category")
    private List<QuizQuestion> quizQuestions;
}

