package com.synoptic.project.repositories;

import com.synoptic.project.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    Iterable<Question> findAllByQuizId(Integer quizId);
}
