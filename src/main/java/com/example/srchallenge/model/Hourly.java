package com.example.srchallenge.model;

public class Hourly {
    private String time;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double temperature_180m;
    private Double uv_index_max;
    private Double uv_index;

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "Hourly{" +
                "time='" + time + '\'' +
                ", temperature_2m=" + temperature_2m +
                ", relative_humidity_2m=" + relative_humidity_2m +
                ", temperature_180m=" + temperature_180m +
                ", uv_index_max=" + uv_index_max +
                ", uv_index=" + uv_index +
                '}';
    }

    public Hourly() {}

    public Hourly(String time, double temperature_2m, int relative_humidity_2m, double temperature_180m, Double uv_index_max, Double uv_index) {
        this.time = time;
        this.temperature_2m = temperature_2m;
        this.relative_humidity_2m = relative_humidity_2m;
        this.temperature_180m = temperature_180m;
        this.uv_index_max = uv_index_max;
        this.uv_index = uv_index;
    }

    // Getters and setters

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public int getRelative_humidity_2m() {
        return relative_humidity_2m;
    }

    public void setRelative_humidity_2m(int relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }

    public double getTemperature_180m() {
        return temperature_180m;
    }

    public void setTemperature_180m(double temperature_180m) {
        this.temperature_180m = temperature_180m;
    }

    public Double getUv_index_max() {
        return uv_index_max;
    }

    public void setUv_index_max(Double uv_index_max) {
        this.uv_index_max = uv_index_max;
    }

    public Double getUv_index() {
        return uv_index;
    }

    public void setUv_index(Double uv_index) {
        this.uv_index = uv_index;
    }
}
