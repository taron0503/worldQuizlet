package com.worldquiz.worldquizrestapi.repositories;

import com.worldquiz.worldquizrestapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findOneByCode(String code);

    Country findOneByName(String name);

    @Query(value = "select code from country", nativeQuery = true)
    List<String> findAllCodes();
}
