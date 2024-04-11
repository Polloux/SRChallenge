package com.example.srchallenge.model;

public class Hourly {
    private String time;
    private int relative_humidity_2m;
    private float temperature_180m;
    private float uv_index;

    @Override
    public String toString() {
        return "Hourly{" +
                "time='" + time + '\'' +
                ", relative_humidity_2m=" + relative_humidity_2m +
                ", temperature_180m=" + temperature_180m +
                ", uv_index=" + uv_index +
                '}';
    }

    public Hourly() {}

    public Hourly(String time, int relative_humidity_2m, float temperature_180m, float uv_index) {
        this.time = time;
        this.relative_humidity_2m = relative_humidity_2m;
        this.temperature_180m = temperature_180m;
        this.uv_index = uv_index;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public void setTemperature_180m(float temperature_180m) {
        this.temperature_180m = temperature_180m;
    }

    public float getUv_index() {
        return uv_index;
    }

    public void setUv_index(Float uv_index) {
        this.uv_index = uv_index;
    }
}
