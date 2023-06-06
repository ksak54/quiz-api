package com.example.quizapi.repository;

import com.example.quizapi.bean.QuizQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<QuizQuestion, Integer>, PagingAndSortingRepository<QuizQuestion, Integer> {

    Optional<QuizQuestion> findByQuestionId(Integer integer);

}
