package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.City;
import com.worldquiz.worldquizrestapi.models.Country;
import com.worldquiz.worldquizrestapi.repositories.CityRepository;
import com.worldquiz.worldquizrestapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class QuizGenerator {
    @Autowired
    CountryRepository countryDao;

    @Autowired
    CityRepository cityDao;

    List<String> countryCodeList;

    public List<Quiz> getQuizzes(int count){
        List<Quiz> quizzes = new ArrayList<>();
        for (int i = 0; i<count;i++){
            Quiz quiz = generateQuiz(QuizType.CapitalByCoutry);
            quizzes.add(quiz);
        }
        return quizzes;
    }

    public Quiz generateQuiz(QuizType quizType){
        Quiz quiz=null;
        String question = "";
        countryCodeList = countryDao.findAllCodes();
        List<String> options = new ArrayList<>();
        switch (quizType){
            case CapitalByCoutry:
                Country country = getRandomCountry();
                question = "Which city is capital of " + country.getName() + "?";
                options = getOptions(quizType);
                options.add(country.getCapital().getName());
                break;
            case  CoutryByCapital:
                City capital = getRandomCapital();
                question = "Which country's capital is " + capital.getName() + "?";
                options = getOptions(quizType);
                options.add(capital.getCountry().getName());
                break;
        }
        Collections.shuffle(options);
        quiz = new Quiz(quizType,question,options);
        return quiz;
    }

    List<String> getOptions(QuizType quizType){
        List<String> options = new ArrayList<>();
        int rand;
        switch (quizType){
            case CapitalByCoutry:
                for(int i = 0;i<3;i++){
                    rand = (int) ((Math.random() * countryCodeList.size()) );
                    options.add(countryDao.findOneByCode(countryCodeList.get(rand)).getCapital().getName());
                }
                break;
            case CoutryByCapital:
                for(int i = 0;i<3;i++){
                    rand = (int) ((Math.random() * countryCodeList.size()) );
                    options.add(countryDao.findOneByCode(countryCodeList.get(rand)).getName());
                }
                break;
        }


        return options;
    }

    Country getRandomCountry(){
        int rand = (int) ((Math.random() * countryCodeList.size()) );
        return countryDao.findOneByCode(countryCodeList.get(rand));
    }

    City getRandomCapital(){
        int rand = (int) ((Math.random() * countryCodeList.size()) );
        return countryDao.findOneByCode(countryCodeList.get(rand)).getCapital();
    }
}
