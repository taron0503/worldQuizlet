package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
//    List<City> findAllByCoutryCode(String coutryCode);
}
