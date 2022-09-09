package com.worldquiz.worldquizrestapi.controllers;

import com.worldquiz.worldquizrestapi.QuizGenerator;
import com.worldquiz.worldquizrestapi.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    QuizGenerator quizGenerator;

    @PostMapping("/getQuestion")
    public String getQuestion(){
        quizGenerator.generateQuiz(QuizType.CapitalByCoutry);
        return "";
    }
}
