package com.example.srchallenge.api;

import com.example.srchallenge.model.Daily;
import com.example.srchallenge.model.Hourly;
import com.example.srchallenge.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Forecast {
    public static Weather getForecast(double latitudeParam, double longitudeParam) throws Exception {
        //https://api.open-meteo.com/v1/forecast?latitude=46.5547&longitude=15.6467&current=temperature_2m,apparent_temperature&hourly=temperature_2m,relative_humidity_2m,temperature_180m,uv_index&daily=temperature_2m_max,temperature_2m_min,uv_index_max&timezone=Europe%2FBerlin&past_days=7&past_hours=24&forecast_hours=24
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude="+ latitudeParam +"&longitude=" + longitudeParam + "&current=temperature_2m,apparent_temperature&hourly=temperature_2m,relative_humidity_2m,temperature_180m,uv_index&daily=temperature_2m_max,temperature_2m_min,uv_index_max&timezone=Europe%2FBerlin&past_days=7&past_hours=24&forecast_hours=24";
        /*URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");*/

        URI uri = URI.create(apiUrl);
        URLConnection connection = uri.toURL().openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        httpConnection.setRequestMethod("GET");


        Weather weather = new Weather();

        int responseCode = ((HttpURLConnection) connection).getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Alternate parsing
            /*Gson gson = new Gson();
            WeatherData weatherData = gson.fromJson(String.valueOf(response), WeatherData.class);
            System.out.println(weatherData.toString());*/

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(String.valueOf(response), JsonObject.class);

            //START HOURLY
            JsonObject hourlyData = jsonObject.getAsJsonObject("hourly");
            JsonArray timeArray = hourlyData.getAsJsonArray("time");
            JsonArray relativeHumidity2mArray = hourlyData.getAsJsonArray("relative_humidity_2m");
            JsonArray temperature180mArray = hourlyData.getAsJsonArray("temperature_180m");
            JsonArray uvIndexArray = hourlyData.getAsJsonArray("uv_index");

            List<Hourly> hourlyList = new ArrayList<>();

            for (int i = 0; i < timeArray.size(); i++) {
                Hourly hourly = new Hourly();
                hourly.setTime(timeArray.get(i).getAsString());
                hourly.setRelative_humidity_2m(relativeHumidity2mArray.get(i).getAsInt());
                hourly.setTemperature_180m(temperature180mArray.get(i).getAsFloat());
                hourly.setUv_index(uvIndexArray.get(i).getAsFloat());
                hourlyList.add(hourly);
            }
            //END HOURLY

            //START DAILY
            JsonObject dailyData = jsonObject.getAsJsonObject("daily");
            JsonArray dailyTimeArray = dailyData.getAsJsonArray("time");
            JsonArray maxTemperatureArray = dailyData.getAsJsonArray("temperature_2m_max");
            JsonArray minTemperatureArray = dailyData.getAsJsonArray("temperature_2m_min");
            JsonArray uvIndexMaxArray = dailyData.getAsJsonArray("uv_index_max");

            List<Daily> dailyList = new ArrayList<>();
            for (int i = 0; i < dailyTimeArray.size(); i++) {
                Daily daily = new Daily();
                daily.setTime(dailyTimeArray.get(i).getAsString());
                daily.setTemperature_2m_max(maxTemperatureArray.get(i).getAsFloat());
                daily.setTemperature_2m_min(minTemperatureArray.get(i).getAsInt());
                daily.setUv_index_max(uvIndexMaxArray.get(i).getAsFloat());
                dailyList.add(daily);
            }

            for (Hourly hourly : hourlyList) {
                String[] split = hourly.getTime().split("T");
                for (Daily daily : dailyList) {
                    if (Objects.equals(split[0], daily.getTime())) {
                        daily.addHourly(hourly);
                    }
                }
            }
            //END DAILY

            //START WEATHER
            float latitude = jsonObject.get("latitude").getAsFloat();
            float longitude = jsonObject.get("longitude").getAsFloat();
            JsonObject current = jsonObject.getAsJsonObject("current");
            float temperature = current.get("temperature_2m").getAsFloat();
            float apparentTemperature = current.get("apparent_temperature").getAsFloat();
            String currentTime = current.get("time").getAsString();

            weather.setDaily(dailyList);
            weather.setLongitude(longitude);
            weather.setLatitude(latitude);
            weather.setCurrentTime(currentTime);
            weather.setTemperature(temperature);
            weather.setApparentTemperature(apparentTemperature);
            //END WEATHER

            //System.out.println(weather);

        } else {
            System.out.println("HTTP request failed with response code: " + responseCode);
        }
        ((HttpURLConnection) connection).disconnect();
        return weather;
    }
}