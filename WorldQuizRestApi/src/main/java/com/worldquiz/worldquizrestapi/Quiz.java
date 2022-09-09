package com.worldquiz.worldquizrestapi;

import java.util.ArrayList;

public class Quiz {
    private String question;
    private QuizType type;
    private ArrayList options;

    public Quiz(QuizType type, ArrayList options) {
        this.type = type;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public QuizType getType() {
        return type;
    }

    public ArrayList getOptions() {
        return options;
    }
}
