package com.example.srchallenge.controller;

import com.example.srchallenge.PropertiesManager;
import com.example.srchallenge.api.Forecast;
import com.example.srchallenge.api.Geocoding;
import com.example.srchallenge.model.City;
import com.example.srchallenge.model.Daily;
import com.example.srchallenge.model.Hourly;
import com.example.srchallenge.model.Weather;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeatherController {
    @FXML
    private ToggleButton editingButton;

    @FXML
    private ToggleButton expandButton;

    @FXML
    ImageView myImage;

    @FXML
    private TextField searchText;

    @FXML
    private Button searchButton;

    @FXML
    private Label cityLabel;

    @FXML
    private ListView<City> cityListView;

    @FXML
    private TextField cityInputField;

    private final Popup valuePopup = new Popup();

    @FXML
    private LineChart<String, Number> lineChart;

    private final ObservableList<City> cities = FXCollections.observableArrayList();

    @FXML
    private void onEditingButtonClick() {
        boolean isSelected = editingButton.isSelected();
        editingButton.setText("✔");
        editingButton.setStyle("-fx-background-color: #C7EA46;");
        cityInputField.setVisible(isSelected);
        searchButton.setVisible(isSelected);
        if (!isSelected) {
            hideSearch();
        }
    }

    @FXML
    protected void initialize() throws Exception {
        valuePopup.setAutoHide(false);
        valuePopup.setHideOnEscape(true);

        Image image = new Image("file:icon.png"); // Assuming weather.png is in the project directory
        myImage = new ImageView(image);

        String userDataPath = "src/main/resources/com/example/srchallenge/userData.properties";
        PropertiesManager propertiesManager = new PropertiesManager(userDataPath);
        String cityName = propertiesManager.get("City").toString();
        cityLabel.setText(cityName);
        City city = Geocoding.search(cityName).get(0);
        updateWeather(city);


        hideSearch();

        cityListView.setItems(cities);
        //TODO SET HEIGHT ACCORDING TO NUMBER OF ITEMS, MAX HEIGHT 5 ELEMENTS
        cityListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("ob" + observable);
                System.out.println("ov" + oldValue);
                System.out.println("nv" + newValue);
                hideSearch();
                propertiesManager.replace("City", newValue.name);
                // Update weather chart based on the selected city
                try {
                    updateWeather(newValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void updateWeather(City city) throws Exception {
        cityLabel.setText(city.name);

        Weather weather = Forecast.getForecast(city.latitude,city.longitude);

        // Clear existing data from the LineChart
        lineChart.getData().clear();

        XYChart.Series<String, Number> temperatureMax = new XYChart.Series<>();
        temperatureMax.setName("Max Temperature");

        XYChart.Series<String, Number> temperatureMin = new XYChart.Series<>();
        temperatureMin.setName("Min Temperature");

        XYChart.Series<String, Number> uv_index_max = new XYChart.Series<>();
        temperatureMin.setName("UV Index");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMM");
        for (Daily daily : weather.getDaily()) {
            LocalDate date = LocalDate.parse(daily.getTime());
            String formattedDate = date.format(formatter);

            // Assuming you want to add maximum temperature for each day
            temperatureMax.getData().add(new XYChart.Data<>(formattedDate, daily.getTemperature_2m_max()));
            temperatureMin.getData().add(new XYChart.Data<>(formattedDate, daily.getTemperature_2m_min()));
            uv_index_max.getData().add(new XYChart.Data<>(formattedDate, daily.getUv_index_max()));

        }

        lineChart.getData().clear();
        lineChart.getData().add(temperatureMax);
        lineChart.getData().add(uv_index_max);
        lineChart.getData().add(temperatureMin);
    }

    @FXML
    protected void searchCity(ActionEvent event) {
        String cityName = cityInputField.getText().trim();
        if (!cityName.isEmpty()) {
            try {
                // Perform city search using Geocoding API
                cities.clear(); // Clear previous search results
                cities.addAll(Geocoding.search(cityName));
                cityListView.setVisible(true);
                cityListView.setMaxHeight(220);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Oh no");
        }
    }

    private void hideSearch() {
        searchButton.setVisible(false);
        cityInputField.setVisible(false);
        cityListView.setMaxHeight(0);
        cityListView.setVisible(false);
        editingButton.setText("\uD83D\uDD0D");
        editingButton.setStyle("-fx-background-color: #9792E3;");
        lineChart.requestLayout();
    }
}
