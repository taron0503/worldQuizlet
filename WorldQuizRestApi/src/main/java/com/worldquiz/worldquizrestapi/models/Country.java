package com.worldquiz.worldquizrestapi.models;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "Continent")
    private String continent;
    @Basic
    @Column(name = "Region")
    private String region;
    @Basic
    @Column(name = "SurfaceArea")
    private double surfaceArea;
    @Basic
    @Column(name = "IndepYear")
    private Short indepYear;
    @Basic
    @Column(name = "Population")
    private int population;
    @Basic
    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;
    @Basic
    @Column(name = "GNP")
    private Double gnp;
    @Basic
    @Column(name = "GNPOld")
    private Double gnpOld;
    @Basic
    @Column(name = "LocalName")
    private String localName;
    @Basic
    @Column(name = "GovernmentForm")
    private String governmentForm;
    @Basic
    @Column(name = "HeadOfState")
    private String headOfState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Capital", referencedColumnName = "ID")
    private City capital;
    @Basic
    @Column(name = "Code2")
    private String code2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country that = (Country) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && population == that.population && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(continent, that.continent) && Objects.equals(region, that.region) && Objects.equals(indepYear, that.indepYear) && Objects.equals(lifeExpectancy, that.lifeExpectancy) && Objects.equals(gnp, that.gnp) && Objects.equals(gnpOld, that.gnpOld) && Objects.equals(localName, that.localName) && Objects.equals(governmentForm, that.governmentForm) && Objects.equals(headOfState, that.headOfState) && Objects.equals(capital, that.capital) && Objects.equals(code2, that.code2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
    }
}
