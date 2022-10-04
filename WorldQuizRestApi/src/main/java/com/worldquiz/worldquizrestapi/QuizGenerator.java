package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.City;
import com.worldquiz.worldquizrestapi.models.Country;
import com.worldquiz.worldquizrestapi.repositories.CityRepository;
import com.worldquiz.worldquizrestapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

@Component
public class QuizGenerator {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    List<String> countryCodeList;

    private int optionsCount=4;

    public List<Quiz> getQuizzes(int count){
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

    public Quiz generateQuiz(QuizType quizType){
        Quiz quiz=null;
        String question = "";
        countryCodeList = countryRepository.findAllCodes();
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
//                options = getOptions(quizType,capital.getCountry());
                options.add(capital.getCountry().getName());
                options = getOptions(quizType,options);
                break;
            case CountryWithLargestPopulaton:
                question = "Which of the following countries has the largest population";
                options = getOptions(quizType,options);
                break;
        }
        Collections.shuffle(options);
        quiz = new Quiz(quizType,question,options);
        return quiz;
    }

    List<String> getOptions(QuizType quizType, List<String> options){
        int rand;
        while(options.size()<optionsCount) {
            rand = (int) ((Math.random() * countryCodeList.size()));
            String countryCode = countryCodeList.get(rand);
            Country country = countryRepository.findByCode(countryCode);

            switch (quizType) {
                case CapitalByCoutry:
                        if (!options.contains(country.getCapital().getName())) {
                            options.add(country.getCapital().getName());
                        }
                    break;
                case CoutryByCapital:
                case CountryWithLargestPopulaton:
                    if (!options.contains(country.getName())) {
                            options.add(country.getName());
                        }
                    break;


            }
        }


        return options;
    }

    Country getRandomCountry(){
        int rand = (int) ((Math.random() * countryCodeList.size()) );
        Country country = countryRepository.findByCode(countryCodeList.get(rand));
        return country;
    }

    City getRandomCapital(){
        int rand = (int) ((Math.random() * countryCodeList.size()) );
        return countryRepository.findOneByCode(countryCodeList.get(rand)).getCapital();
    }
}
