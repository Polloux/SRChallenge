package com.example.srchallenge.model.alternative;

class CurrentData {
    private String time;
    private int interval;
    private double temperature_2m;
    private double apparent_temperature;
    private int weather_code;

    public CurrentData(String time, int interval, double temperature_2m, double apparent_temperature, int weather_code) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature_2m;
        this.apparent_temperature = apparent_temperature;
        this.weather_code = weather_code;
    }

    public String getTime() {
        return time;
    }
    public int getInterval() {
        return interval;
    }
    public double getTemperature_2m() {
        return temperature_2m;
    }
    public double getApparent_temperature() {
        return apparent_temperature;
    }
    public int getWeather_code() {
        return weather_code;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
    public void setTemperature_2m(double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }
    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CurrentData{" +
                "time='" + time + '\'' +
                ", interval=" + interval +
                ", temperature_2m=" + temperature_2m +
                ", apparent_temperature=" + apparent_temperature +
                ", weather_code=" + weather_code +
                '}';
    }
}
