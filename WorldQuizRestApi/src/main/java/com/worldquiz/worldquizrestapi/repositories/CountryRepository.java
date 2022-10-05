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

    @Query(value = "select code from country where capital is not null", nativeQuery = true)
    List<String> findAllCodes();

    @Query(value = "SELECT name from country where Population = (select max(Population) FROM world.country where name in (:countries))", nativeQuery = true)
    String findCountryWithLargestPopultion(@Param("countries") List<String> countries);
}
