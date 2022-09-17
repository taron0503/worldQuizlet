package com.worldquiz.worldquizrestapi.repositories;

import com.worldquiz.worldquizrestapi.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
    City findById(Integer id);

    City findOneByName(String countryName);
}
