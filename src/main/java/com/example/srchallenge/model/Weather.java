package com.example.srchallenge.model;

import java.util.List;

public class Weather {
    private List<Daily> daily;
    private float longitude;
    private float latitude;
    private String currentTime;
    private float temperature;
    private float apparentTemperature;

    @Override
    public String toString() {
        return "Weather{" +
                "daily=" + daily +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", currentTime='" + currentTime + '\'' +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                '}';
    }

    public Weather(List<Daily> daily, float longitude, float latitude, String currentTime, float temperature, float apparentTemperature) {
        this.daily = daily;
        this.longitude = longitude;
        this.latitude = latitude;
        this.currentTime = currentTime;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
    }

    public Weather() {}

    public List<Daily> getDaily() {
        return daily;
    }
    public float getApparentTemperature() {
        return apparentTemperature;
    }
    public float getLongitude() {
        return longitude;
    }
    public float getTemperature() {
        return temperature;
    }
    public float getLatitude() {
        return latitude;
    }
    public String getCurrentTime() {
        return currentTime;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public void setApparentTemperature(float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

}
