package com.example.srchallenge.model;

import java.util.List;

class HourlyData {
    private List<String> time;
    private List<Double> temperature_2m;
    private List<Integer> relative_humidity_2m;
    private List<Double> temperature_180m;
    private List<Double> uv_index;

    public HourlyData(List<String> time, List<Double> temperature_2m, List<Integer> relative_humidity_2m, List<Double> temperature_180m, List<Double> uv_index) {
        this.time = time;
        this.temperature_2m = temperature_2m;
        this.relative_humidity_2m = relative_humidity_2m;
        this.temperature_180m = temperature_180m;
        this.uv_index = uv_index;
    }

    public List<String> getTime() {
        return time;
    }
    public List<Double> getTemperature_2m() {
        return temperature_2m;
    }
    public List<Double> getUv_index() {
        return uv_index;
    }
    public List<Integer> getRelative_humidity_2m() {
        return relative_humidity_2m;
    }
    public List<Double> getTemperature_180m() {
        return temperature_180m;
    }

    public void setRelative_humidity_2m(List<Integer> relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }
    public void setUv_index(List<Double> uv_index) {
        this.uv_index = uv_index;
    }
    public void setTime(List<String> time) {
        this.time = time;
    }
    public void setTemperature_2m(List<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
    public void setTemperature_180m(List<Double> temperature_180m) {
        this.temperature_180m = temperature_180m;
    }

    @Override
    public String toString() {
        return "HourlyData{" +
                "time=" + time +
                ", temperature_2m=" + temperature_2m +
                ", relative_humidity_2m=" + relative_humidity_2m +
                ", temperature_180m=" + temperature_180m +
                ", uv_index=" + uv_index +
                '}';
    }
}
