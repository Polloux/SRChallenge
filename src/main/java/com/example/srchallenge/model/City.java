package com.example.srchallenge.model;

public class City {
    public String name;
    public String country_code;
    public String country;

    public City(){}

    //GETTERS
    public String getName() {
        return name;
    }
    public String getCountry_code() {
        return country_code;
    }
    public String getCountry() {
        return country;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    //UNNECESSARY API JSON DATA
    public int id;
    public double longitude;
    public double latitude;
    public double elevation;
    public String feature_code;
    public int admin1_id;
    public String timezone;
    public int population;
    public int country_id;
    public String admin1;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country_code='" + country_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}