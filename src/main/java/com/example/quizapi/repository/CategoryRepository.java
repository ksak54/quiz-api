package com.example.quizapi.repository;

import com.example.quizapi.bean.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>, PagingAndSortingRepository<Category, Integer> {

    Optional<Category> findByCategoryId(Integer integer);
}
