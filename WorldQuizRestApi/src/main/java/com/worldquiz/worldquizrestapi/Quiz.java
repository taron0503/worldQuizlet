package com.worldquiz.worldquizrestapi;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String question;
    private QuizType type;
    private List<String> options;

    private String answer=null;

    public Quiz(){}

    public Quiz(QuizType type, String question, List<String> options) {
        this.type = type;
        this.question = question;
        this.options = options;
    }

    public Quiz(QuizType type, String question, String answer) {
        this.type = type;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public QuizType getType() {
        return type;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setType(QuizType type) {
        this.type = type;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
