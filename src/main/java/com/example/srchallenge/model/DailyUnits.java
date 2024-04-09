package com.example.srchallenge.model;

class DailyUnits {
    private String time;
    private String temperature_2m_max;
    private String temperature_2m_min;
    private String uv_index_max;

    public DailyUnits(String time, String temperature_2m_max, String temperature_2m_min, String uv_index_max) {
        this.time = time;
        this.temperature_2m_max = temperature_2m_max;
        this.temperature_2m_min = temperature_2m_min;
        this.uv_index_max = uv_index_max;
    }

    public String getTime() {
        return time;
    }
    public String getTemperature_2m_max() {
        return temperature_2m_max;
    }
    public String getTemperature_2m_min() {
        return temperature_2m_min;
    }
    public String getUv_index_max() {
        return uv_index_max;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setUv_index_max(String uv_index_max) {
        this.uv_index_max = uv_index_max;
    }
    public void setTemperature_2m_max(String temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }
    public void setTemperature_2m_min(String temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    @Override
    public String toString() {
        return "DailyUnits{" +
                "time='" + time + '\'' +
                ", temperature_2m_max='" + temperature_2m_max + '\'' +
                ", temperature_2m_min='" + temperature_2m_min + '\'' +
                ", uv_index_max='" + uv_index_max + '\'' +
                '}';
    }
}