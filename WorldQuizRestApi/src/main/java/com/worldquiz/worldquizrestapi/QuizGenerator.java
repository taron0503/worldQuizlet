package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.City;
import com.worldquiz.worldquizrestapi.models.Country;
import com.worldquiz.worldquizrestapi.repositories.CityRepository;
import com.worldquiz.worldquizrestapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class QuizGenerator {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    List<String> countryCodeList;

    private int optionsCount=4;

    public List<Quiz> getQuizzes(int count){
        countryCodeList = countryRepository.findAllCodes();
        List<Quiz> quizzes = new ArrayList<>();
        QuizType[] values =  QuizType.values();
        int rand;
        for (int i = 0; i<count;i++){
            rand = (int) (Math.random() * values.length);
            Quiz quiz = generateQuiz(values[rand]);
            quizzes.add(quiz);
        }
        return quizzes;
    }

    private Quiz generateQuiz(QuizType quizType){
        String question = "";
        List<String> options = new ArrayList<>();
        switch (quizType){
            case CapitalByCoutry:
                Country country = getRandomCountry();
                question = "What is the Capital of " + country.getName() + "?";
                options.add(country.getCapital().getName());
                options = getOptions(quizType,options);
                break;
            case  CoutryByCapital:
                City capital = getRandomCapital();
                question = "Which country's capital is " + capital.getName() + "?";
                options.add(capital.getCountry().getName());
                options = getOptions(quizType,options);
                break;
            case CountryWithLargestPopulation:
                question = "Which of the following countries has the largest population?";
                options = getOptions(quizType,options);
                break;
        }
        Collections.shuffle(options);
        return new Quiz(quizType,question,options);
    }

    private List<String> getOptions(QuizType quizType, List<String> options){
        int rand;
        while(options.size()<optionsCount) {
            Country country = getRandomCountry();

            switch (quizType) {
                case CapitalByCoutry:
                        if (!options.contains(country.getCapital().getName())) {
                            options.add(country.getCapital().getName());
                        }
                    break;
                case CoutryByCapital:
                case CountryWithLargestPopulation:
                    if (!options.contains(country.getName())) {
                            options.add(country.getName());
                        }
                    break;


            }
        }


        return options;
    }

    private Country getRandomCountry(){
        int rand;
        Country country;
        boolean badCountryName;
        boolean badCapitalName;
        do{
            rand = (int) ((Math.random() * countryCodeList.size()) );
            country = countryRepository.findByCode(countryCodeList.get(rand));;
            badCountryName = Pattern.compile("[^a-zA-Z -]").matcher(country.getName()).find();
            badCapitalName = Pattern.compile("[^a-zA-Z -]").matcher(country.getCapital().getName()).find();
        }while (badCountryName || badCapitalName);

        return country;
    }

    private City getRandomCapital(){
        int rand;
        City capital;
        boolean badCaitalName;
        boolean badCountryName;
        do{
            rand = (int) ((Math.random() * countryCodeList.size()) );
            capital = countryRepository.findOneByCode(countryCodeList.get(rand)).getCapital();
            badCaitalName = Pattern.compile("[^a-zA-Z -]").matcher(capital.getName()).find();
            badCountryName = Pattern.compile("[^a-zA-Z -]").matcher(capital.getCountry().getName()).find();
        }while (badCaitalName || badCountryName);

        return capital;
    }
}
