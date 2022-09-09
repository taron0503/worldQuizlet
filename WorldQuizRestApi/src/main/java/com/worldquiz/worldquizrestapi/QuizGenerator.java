package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizGenerator {
    @Autowired
    CountryRepository countryDao;

    @Autowired
    CityRepository cityDao;

    public void generateQuiz(QuizType quizType){
        String question = "";
        List<String> countryCodeList = countryDao.findAllCodes();
        System.out.println(countryCodeList);
        ArrayList<String> options = new ArrayList<>();
        switch (quizType){
            case CapitalByCoutry:
                Object country = countryDao.findByName("POLand");
//                question = "Which city is capital of " + country.getName() + "?";
               // options = cityDao.findAllByCoutryCode("").stream().map(city->city.getName()).toArray();
                break;
            case  CoutryByCapital:
                //question = "Which country's capital is " + country.getCapital() + "?";
                break;
        }
    }
}
