package com.synoptic.project.controller;

import com.synoptic.project.model.Quiz;
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

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ModelAndView getAllQuizzes() {
        Iterable<Quiz> quizzes = quizService.getAllQuizzes();
        return new ModelAndView("quizzes/index", "quizzes", quizzes);
    }
}
