package com.example.srchallenge.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Geocoding {
    public static void search(String searchStr) throws Exception {
        //https://geocoding-api.open-meteo.com/v1/search?name=Maribor&count=10&language=en&format=json
        String apiUrl = "https://geocoding-api.open-meteo.com/v1/search?name=" + searchStr + "&count=10&language=en&format=json";
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response: " + response);
        } else {
            System.out.println("HTTP request failed with response code: " + responseCode);
        }

        connection.disconnect();
    }
}