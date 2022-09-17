package com.worldquiz.worldquizrestapi.controllers;

import com.worldquiz.worldquizrestapi.Quiz;
import com.worldquiz.worldquizrestapi.QuizGenerator;
import com.worldquiz.worldquizrestapi.QuizManager;
import com.worldquiz.worldquizrestapi.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
public class HomeController {
    @Autowired
    QuizGenerator quizGenerator;

    @Autowired
    QuizManager quizManager;

    @PostMapping("/getQuestion")
    public Quiz getQuestion(){
        Quiz quiz = quizGenerator.generateQuiz(QuizType.CoutryByCapital);
        return quiz;
    }

    @PostMapping("/checkAnswers")
    public List<Integer> checkAnswers(@RequestBody ArrayList<Quiz> quizzes){
        List<Integer> responses = quizManager.checkAnswers(quizzes);
        return responses;
    }
}

