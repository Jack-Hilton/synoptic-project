package com.synoptic.project.controller;

import com.synoptic.project.model.Question;
import com.synoptic.project.model.Quiz;
import com.synoptic.project.services.QuestionService;
import com.synoptic.project.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/questions/answers/{questionId}")
    public ModelAndView getAllAnswersForQuestion(@PathVariable Integer questionId) {
        Iterable<Question> answers = questionService.getAllAnswersForQuestion(questionId);
        return new ModelAndView("quizzes/answers", "answers", answers);
    }

    @GetMapping("/delete/{quizId}")
    public RedirectView deleteQuiz(@PathVariable Integer quizId) {
        quizService.deleteQuizById(quizId);
        return new RedirectView("/quiz/");
    }

    @GetMapping("/{quizId}/question/{questionId}")
    public RedirectView deleteQuestion(@PathVariable Integer quizId, @PathVariable Integer questionId) {
        questionService.deleteQuestionsById(questionId);
        return new RedirectView("/quiz/questions/{quizId}");
    }

    @GetMapping("/{quizId}/question/new/")
    public ModelAndView newQuestion(@PathVariable Integer quizId) {
        return new ModelAndView("quizzes/newQuestion", "question", new Question());
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public RedirectView addQuestion(@ModelAttribute Question question, BindingResult errors, Model model) {
        model.addAttribute("question", question);
        return new RedirectView("/quiz/");
    }
}
