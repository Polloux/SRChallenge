package com.example.srchallenge.model.alternative;

class HourlyUnits {
    private String time;
    private String temperature_2m;
    private String relative_humidity_2m;
    private String temperature_180m;
    private String uv_index;

    public HourlyUnits(String time, String temperature_2m, String relative_humidity_2m, String temperature_180m, String uv_index) {
        this.time = time;
        this.temperature_2m = temperature_2m;
        this.relative_humidity_2m = relative_humidity_2m;
        this.temperature_180m = temperature_180m;
        this.uv_index = uv_index;
    }

    public String getTime() {
        return time;
    }
    public String getTemperature_2m() {
        return temperature_2m;
    }
    public String getRelative_humidity_2m() {
        return relative_humidity_2m;
    }
    public String getTemperature_180m() {
        return temperature_180m;
    }
    public String getUv_index() {
        return uv_index;
    }

    public void setRelative_humidity_2m(String relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }
    public void setTemperature_180m(String temperature_180m) {
        this.temperature_180m = temperature_180m;
    }
    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
    public void setUv_index(String uv_index) {
        this.uv_index = uv_index;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HourlyUnits{" +
                "time='" + time + '\'' +
                ", temperature_2m='" + temperature_2m + '\'' +
                ", relative_humidity_2m='" + relative_humidity_2m + '\'' +
                ", temperature_180m='" + temperature_180m + '\'' +
                ", uv_index='" + uv_index + '\'' +
                '}';
    }
}
