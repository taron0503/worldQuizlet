package com.worldquiz.worldquizrestapi;

import com.worldquiz.worldquizrestapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findAllByName(String name);

    @Query(value = "select code from country", nativeQuery = true)
    List<String> findAllCodes();
}
