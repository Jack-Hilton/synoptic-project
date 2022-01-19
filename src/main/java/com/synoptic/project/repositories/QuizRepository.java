package com.synoptic.project.repositories;

import com.synoptic.project.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Integer> { }