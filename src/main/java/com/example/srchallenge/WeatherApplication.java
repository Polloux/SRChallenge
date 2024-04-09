package com.example.srchallenge;

import com.example.srchallenge.api.Geocoding;
import com.example.srchallenge.model.City;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class WeatherApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String userDataPath = "src/main/resources/com/example/srchallenge/userData.properties";
        PropertiesManager propertiesManager = new PropertiesManager(userDataPath);

        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        ArrayList<City> cities =  Geocoding.search("Maribor");
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}