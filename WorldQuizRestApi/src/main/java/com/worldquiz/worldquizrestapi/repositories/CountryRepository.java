package com.worldquiz.worldquizrestapi.repositories;

import com.worldquiz.worldquizrestapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findOneByCode(String code);

    Country findOneByName(String name);

    Country findByCode(String code);

    @Query("select c.code from Country c where c.capital is not null")
    List<String> findAllCodes();

    @Query("SELECT c.name from Country c where c.population = (select max(c.population) FROM c where c.name in (:countries))")
    String findCountryWithLargestPopultion(@Param("countries") List<String> countries);
}
