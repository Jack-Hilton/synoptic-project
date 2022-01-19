package com.synoptic.project.services;

import com.synoptic.project.model.Quiz;
import com.synoptic.project.repositories.QuizRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Iterable<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> findByQuizId(Integer id) {
        return quizRepository.findById(id);
    }

    public Quiz updateOrCreateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuizById(Integer id) {
        quizRepository.deleteById(id);
    }
}
