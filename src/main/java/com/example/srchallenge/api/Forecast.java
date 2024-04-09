package com.example.srchallenge.api;

import com.example.srchallenge.model.City;
import com.example.srchallenge.model.Hourly;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Forecast {
    public static ArrayList<City> getForecast() throws Exception {
        //https://api.open-meteo.com/v1/forecast?latitude=46.5547&longitude=15.6467&current=temperature_2m,apparent_temperature,is_day,weather_code&hourly=temperature_2m,relative_humidity_2m,temperature_180m,uv_index&daily=temperature_2m_max,temperature_2m_min,uv_index_max&timezone=Europe%2FBerlin&past_days=7&past_hours=24&forecast_hours=24
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=46.5547&longitude=15.6467&current=temperature_2m,apparent_temperature,is_day,weather_code&hourly=temperature_2m,relative_humidity_2m,temperature_180m,uv_index&daily=temperature_2m_max,temperature_2m_min,uv_index_max&timezone=Europe%2FBerlin&past_days=7&past_hours=24&forecast_hours=24";
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        ArrayList<City> cities = new ArrayList<>();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            /*Gson gson = new Gson();
            WeatherData weatherData = gson.fromJson(String.valueOf(response), WeatherData.class);
            System.out.println(weatherData.toString());*/

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(String.valueOf(response), JsonObject.class);
            JsonObject hourlyData = jsonObject.getAsJsonObject("hourly");

            JsonArray timeArray = hourlyData.getAsJsonArray("time");
            JsonArray temperature2mArray = hourlyData.getAsJsonArray("temperature_2m");
            JsonArray relativeHumidity2mArray = hourlyData.getAsJsonArray("relative_humidity_2m");
            JsonArray temperature180mArray = hourlyData.getAsJsonArray("temperature_180m");
            JsonArray uvIndexMaxArray = hourlyData.getAsJsonArray("uv_index_max");
            JsonArray uvIndexArray = hourlyData.getAsJsonArray("uv_index");

            List<Hourly> hourlyList = new ArrayList<>();

            for (int i = 0; i < timeArray.size(); i++) {
                Hourly hourly = new Hourly();

                hourly.setTime(timeArray.get(i).getAsString());
                hourly.setTemperature_2m(temperature2mArray.get(i).getAsDouble());
                hourly.setRelative_humidity_2m(relativeHumidity2mArray.get(i).getAsInt());
                hourly.setTemperature_180m(temperature180mArray.get(i).getAsDouble());

                if (uvIndexMaxArray == null){
                    hourly.setUv_index_max(null);
                } else {
                    JsonElement uvIndexMaxElement = uvIndexMaxArray.get(i);
                    hourly.setUv_index_max(uvIndexMaxElement.getAsDouble());
                }

                if (uvIndexArray == null){
                    hourly.setUv_index(null);
                } else {
                    JsonElement uvIndexElement = uvIndexArray.get(i);
                    hourly.setUv_index_max(uvIndexElement.getAsDouble());
                }

                hourlyList.add(hourly);
            }

            for (Hourly hourly : hourlyList) {
                System.out.println(hourly.toString());
            }

            // Now hourlyList contains all the Hourly objects with null UV index handled

        } else {
            System.out.println("HTTP request failed with response code: " + responseCode);
        }
        connection.disconnect();
        return cities;
    }
}