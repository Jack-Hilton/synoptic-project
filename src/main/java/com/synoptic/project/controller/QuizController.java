package com.synoptic.project.controller;

import com.synoptic.project.model.Question;
import com.synoptic.project.model.Quiz;
import com.synoptic.project.services.QuestionService;
import com.synoptic.project.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;

    @Autowired
    public QuizController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping
    public ModelAndView getAllQuizzes() {
        Iterable<Quiz> quizzes = quizService.getAllQuizzes();
        return new ModelAndView("quizzes/index", "quizzes", quizzes);
    }

    @GetMapping("/questions/{quizId}")
    public ModelAndView getAllQuestionsForQuiz(@PathVariable Integer quizId) {
        Iterable<Question> questions = questionService.getAllQuestionsForQuiz(quizId);
        return new ModelAndView("quizzes/questions", "questions", questions);
    }
}
