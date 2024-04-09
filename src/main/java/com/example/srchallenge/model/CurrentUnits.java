package com.example.srchallenge.model;

class CurrentUnits {
    private String time;
    private String interval;
    private String temperature_2m;
    private String apparent_temperature;
    private String weather_code;

    public CurrentUnits(String time, String interval, String temperature_2m, String apparent_temperature, String weather_code) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature_2m;
        this.apparent_temperature = apparent_temperature;
        this.weather_code = weather_code;
    }

    public String getTime() {
        return time;
    }
    public String getInterval() {
        return interval;
    }
    public String getTemperature_2m() {
        return temperature_2m;
    }
    public String getApparent_temperature() {
        return apparent_temperature;
    }
    public String getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setInterval(String interval) {
        this.interval = interval;
    }
    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
    public void setApparent_temperature(String apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    @Override
    public String toString() {
        return "CurrentUnits{" +
                "time='" + time + '\'' +
                ", interval='" + interval + '\'' +
                ", temperature_2m='" + temperature_2m + '\'' +
                ", apparent_temperature='" + apparent_temperature + '\'' +
                ", weather_code='" + weather_code + '\'' +
                '}';
    }
}
