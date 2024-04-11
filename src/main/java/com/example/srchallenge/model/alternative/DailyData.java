package com.example.srchallenge.model.alternative;

import java.util.List;

class DailyData {
    private List<String> time;
    private List<Double> temperature_2m_max;
    private List<Double> temperature_2m_min;
    private List<Double> uv_index_max;

    public DailyData(List<String> time, List<Double> temperature_2m_max, List<Double> temperature_2m_min, List<Double> uv_index_max) {
        this.time = time;
        this.temperature_2m_max = temperature_2m_max;
        this.temperature_2m_min = temperature_2m_min;
        this.uv_index_max = uv_index_max;
    }

    public List<String> getTime() {
        return time;
    }
    public List<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }
    public List<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }
    public List<Double> getUv_index_max() {
        return uv_index_max;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }
    public void setTemperature_2m_max(List<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }
    public void setTemperature_2m_min(List<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }
    public void setUv_index_max(List<Double> uv_index_max) {
        this.uv_index_max = uv_index_max;
    }

    @Override
    public String toString() {
        return "DailyData{" +
                "time=" + time +
                ", temperature_2m_max=" + temperature_2m_max +
                ", temperature_2m_min=" + temperature_2m_min +
                ", uv_index_max=" + uv_index_max +
                '}';
    }
}