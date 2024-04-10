package com.example.srchallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Daily {
    private String time;
    private float temperature_2m_max;
    private float temperature_2m_min;
    private float uv_index_max;
    private List<Hourly> hourly;

    public Daily() {
        hourly = new ArrayList<>();
    }

    public Daily(String time, float temperature_2m_max, float temperature_2m_min, float uv_index_max, List<Hourly> hourly) {
        this.time = time;
        this.temperature_2m_max = temperature_2m_max;
        this.temperature_2m_min = temperature_2m_min;
        this.uv_index_max = uv_index_max;
        this.hourly = hourly;
    }

    public String getTime() {
        return time;
    }
    public float getTemperature_2m_max() {
        return temperature_2m_max;
    }
    public float getTemperature_2m_min() {
        return temperature_2m_min;
    }
    public float getUv_index_max() {
        return uv_index_max;
    }
    public List<Hourly> getHourly() {
        return hourly;
    }

    public void addHourly(Hourly hour) {hourly.add(hour);}
    public void setTime(String time) {
        this.time = time;
    }
    public void setTemperature_2m_max(float temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }
    public void setTemperature_2m_min(float temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }
    public void setUv_index_max(float uv_index_max) {
        this.uv_index_max = uv_index_max;
    }
    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "time='" + time + '\'' +
                ", temperature_2m_max=" + temperature_2m_max +
                ", temperature_2m_min=" + temperature_2m_min +
                ", uv_index_max=" + uv_index_max +
                ", hourly=" + hourly +
                '}';
    }
}
