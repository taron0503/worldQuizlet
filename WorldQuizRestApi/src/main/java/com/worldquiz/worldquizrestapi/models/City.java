package com.worldquiz.worldquizrestapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "world", catalog = "")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "CountryCode")
    private String countryCode;
    @Basic
    @Column(name = "District")
    private String district;
    @Basic
    @Column(name = "Population")
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City that = (City) o;
        return id == that.id && population == that.population && Objects.equals(name, that.name) && Objects.equals(countryCode, that.countryCode) && Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryCode, district, population);
    }
}
