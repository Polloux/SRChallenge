package com.example.srchallenge.api;

import com.example.srchallenge.model.City;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;

public class Geocoding {
    public static ArrayList<City> search(String searchStr) throws Exception {
        //https://geocoding-api.open-meteo.com/v1/search?name=Maribor&count=10&language=en&format=json
        String apiUrl = "https://geocoding-api.open-meteo.com/v1/search?name=" + searchStr + "&count=10&language=en&format=json";
        /*URL url = new URL(apiUrl);
        HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
        connection1.setRequestMethod("GET");*/

        URI uri = URI.create(apiUrl);
        URLConnection connection = uri.toURL().openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        httpConnection.setRequestMethod("GET");


        ArrayList<City> cities = new ArrayList<>();
        int responseCode = ((HttpURLConnection) connection).getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            //System.out.println("Response: " + response);

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(String.valueOf(response), JsonObject.class);
            JsonArray resultsArray = jsonObject.getAsJsonArray("results");

            for (int i = 0; i < resultsArray.size(); i++) {
                JsonObject resultObject = resultsArray.get(i).getAsJsonObject();
                City city = gson.fromJson(resultObject, City.class);
                cities.add(city);
            }
        } else {
            System.out.println("HTTP request failed with response code: " + responseCode);
        }
        ((HttpURLConnection) connection).disconnect();
        return cities;
    }
}