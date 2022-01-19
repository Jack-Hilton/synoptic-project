package com.synoptic.project.services;

import com.synoptic.project.model.Question;
import com.synoptic.project.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Iterable<Question> getAllQuestionsForQuiz(Integer quizId) {
        return questionRepository.findAllByQuizId(quizId);
    }
}
