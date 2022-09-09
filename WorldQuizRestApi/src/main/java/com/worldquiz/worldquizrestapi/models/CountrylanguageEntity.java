package com.worldquiz.worldquizrestapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countrylanguage", schema = "world", catalog = "")
@IdClass(CountrylanguageEntityPK.class)
public class CountrylanguageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CountryCode")
    private String countryCode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Language")
    private String language;
    @Basic
    @Column(name = "IsOfficial")
    private String isOfficial;
    @Basic
    @Column(name = "Percentage")
    private double percentage;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountrylanguageEntity that = (CountrylanguageEntity) o;
        return Double.compare(that.percentage, percentage) == 0 && Objects.equals(countryCode, that.countryCode) && Objects.equals(language, that.language) && Objects.equals(isOfficial, that.isOfficial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language, isOfficial, percentage);
    }
}
