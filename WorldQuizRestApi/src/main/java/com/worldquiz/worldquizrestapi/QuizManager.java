package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.Country;
import com.worldquiz.worldquizrestapi.repositories.CityRepository;
import com.worldquiz.worldquizrestapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuizManager {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    public List<Integer> checkAnswers(List<Quiz> quizzes){
        List<Integer> responses = new ArrayList<>();
        String question;
        String answer;
        for (Quiz quiz : quizzes) {
            switch (quiz.getType()){
                case CapitalByCoutry:
                    answer =  quiz.getAnswer();
                    question = quiz.getQuestion();
                    String countryName = question.substring(question.indexOf("of ")+3,question.indexOf("?"));
                    if(countryRepository.findOneByName(countryName).getCapital().getName().equals(answer)){
                        responses.add(1);
                    }else {
                        responses.add(0);
                    }
                    break;
                case CoutryByCapital:
                    answer =  quiz.getAnswer();
                    question = quiz.getQuestion();
                    String capitalName = question.substring(question.indexOf("is ")+3,question.indexOf("?"));
                    if(cityRepository.findOneByName(capitalName).getCountry().getName().equals(answer)){
                        responses.add(1);
                    }else {
                        responses.add(0);
                    }
                    break;
                case CountryWithLargestPopulaton:
                    answer =  quiz.getAnswer();
                    List<String> options = quiz.getOptions();
                    String country = countryRepository.findCountryWithLargestPopultion(options);
                    if(country.equals(answer)){
                        responses.add(1);
                    }else {
                        responses.add(0);
                    }
                    break;
            }
        }

        return responses;

    }
}
