package com.example.srchallenge.model.alternative;

public class WeatherData {
    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private int elevation;
    private CurrentUnits current_units;
    private CurrentData current;
    private HourlyUnits hourly_units;
    private HourlyData hourly;
    private DailyUnits daily_units;
    private DailyData daily;

    // GETTERS
    public DailyUnits getDaily_units() {
        return daily_units;
    }
    public double getLatitude() {
        return latitude;
    }
    public HourlyUnits getHourly_units() {
        return hourly_units;
    }
    public DailyData getDaily() {
        return daily;
    }
    public double getLongitude() {
        return longitude;
    }
    public double getGenerationtime_ms() {
        return generationtime_ms;
    }
    public int getUtc_offset_seconds() {
        return utc_offset_seconds;
    }
    public String getTimezone() {
        return timezone;
    }
    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }
    public int getElevation() {
        return elevation;
    }
    public CurrentUnits getCurrent_units() {
        return current_units;
    }
    public CurrentData getCurrent() {
        return current;
    }
    public HourlyData getHourly() {
        return hourly;
    }

    // SETTERS
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setDaily(DailyData daily) {
        this.daily = daily;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setDaily_units(DailyUnits daily_units) {
        this.daily_units = daily_units;
    }
    public void setGenerationtime_ms(double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }
    public void setHourly(HourlyData hourly) {
        this.hourly = hourly;
    }
    public void setHourly_units(HourlyUnits hourly_units) {
        this.hourly_units = hourly_units;
    }
    public void setCurrent(CurrentData current) {
        this.current = current;
    }
    public void setCurrent_units(CurrentUnits current_units) {
        this.current_units = current_units;
    }
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public void setUtc_offset_seconds(int utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationtime_ms=" + generationtime_ms +
                ", utc_offset_seconds=" + utc_offset_seconds +
                ", timezone='" + timezone + '\'' +
                ", timezone_abbreviation='" + timezone_abbreviation + '\'' +
                ", elevation=" + elevation +
                ", current_units=" + current_units +
                ", current=" + current +
                ", hourly_units=" + hourly_units +
                ", hourly=" + hourly +
                ", daily_units=" + daily_units +
                ", daily=" + daily +
                '}';
    }
}