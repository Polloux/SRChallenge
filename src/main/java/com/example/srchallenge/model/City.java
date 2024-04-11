package com.example.srchallenge.model;

public class City {
    public String name;
    public String country_code;
    public String country;
    public double longitude;
    public double latitude;

    public City(){}

    //UNNECESSARY API JSON DATA
    public int id;
    public double elevation;
    public String feature_code;
    public int admin1_id;
    public String timezone;
    public int population;
    public int country_id;
    public String admin1;

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
    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
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
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return  name + ", " + country;
    }
}