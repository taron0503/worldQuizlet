package com.worldquiz.worldquizrestapi.controllers;

import com.worldquiz.worldquizrestapi.Quiz;
import com.worldquiz.worldquizrestapi.QuizGenerator;
import com.worldquiz.worldquizrestapi.QuizManager;
import com.worldquiz.worldquizrestapi.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    QuizGenerator quizGenerator;

    @Autowired
    QuizManager quizManager;

    @PostMapping("/getQuestion")

    public List<Quiz> getQuestion(){
//        return quizGenerator.generateQuiz(QuizType.CoutryByCapital);
        return quizGenerator.getQuizzes(4);
    }

    @PostMapping("/checkAnswers")
    public List<Integer> checkAnswers(@RequestBody ArrayList<Quiz> quizzes){
        List<Integer> responses = quizManager.checkAnswers(quizzes);
        return responses;
    }
}

