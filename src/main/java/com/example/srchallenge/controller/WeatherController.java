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
import javafx.stage.Popup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherController {
    @FXML
    private ToggleButton editingButton;

    @FXML
    private ToggleButton expandButton;

    @FXML
    private TextField searchText;

    @FXML
    private Button searchButton;

    @FXML
    private Label cityLabel;

    @FXML
    private Label currentTemp;

    @FXML
    private Label apparentTemp;

    @FXML
    private Label currentTime;

    @FXML
    private Label currentDate;

    @FXML
    private ListView<City> cityListView;

    @FXML
    private TextField cityInputField;

    private final Popup valuePopup = new Popup();

    @FXML
    private LineChart<String, Number> lineChart;

    private final ObservableList<City> cities = FXCollections.observableArrayList();

    boolean expanded = false;

    @FXML
    private void onEditingButtonClick() {
        boolean isSelected = editingButton.isSelected();
        editingButton.setText("✔");
        editingButton.setStyle("-fx-background-color: #A0D4A0;");
        cityInputField.setVisible(isSelected);
        searchButton.setVisible(isSelected);
        if (!isSelected) {
            hideSearch();
        }
    }

    @FXML
    public void onExpandButtonClick() throws Exception {
        if (expanded) {
            expandButton.setText("Open details");
        } else {
            expandButton.setText("Open overview");
        }
        initialize();
        expanded = !expanded;
    }

    @FXML
    protected void initialize() throws Exception {
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
                hideSearch();
                propertiesManager.replace("City", newValue.name);
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
        setTopOfApp(weather);

        lineChart.getData().clear();
        if (expanded) {
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

                temperatureMax.getData().add(new XYChart.Data<>(formattedDate, daily.getTemperature_2m_max()));
                temperatureMin.getData().add(new XYChart.Data<>(formattedDate, daily.getTemperature_2m_min()));
                uv_index_max.getData().add(new XYChart.Data<>(formattedDate, daily.getUv_index_max()));
            }

            lineChart.getData().clear();
            lineChart.getData().add(temperatureMax);
            lineChart.getData().add(uv_index_max);
            lineChart.getData().add(temperatureMin);
        } else {
            XYChart.Series<String, Number> temperature_180m = new XYChart.Series<>();
            temperature_180m.setName("Temperature");
            XYChart.Series<String, Number> relative_humidity_2m = new XYChart.Series<>();
            relative_humidity_2m.setName("Relative Humidity");
            XYChart.Series<String, Number> uv_index = new XYChart.Series<>();
            uv_index.setName("UV Index");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. HH:mm");
            for (Daily daily : weather.getDaily()) {
                for (Hourly hourly : daily.getHourly()) {
                    LocalDateTime dateTime = LocalDateTime.parse(hourly.getTime());
                    String formattedDateTime = dateTime.format(formatter);
                    temperature_180m.getData().add(new XYChart.Data<>(formattedDateTime, hourly.getTemperature_180m()));
                    relative_humidity_2m.getData().add(new XYChart.Data<>(formattedDateTime, hourly.getRelative_humidity_2m()));
                    uv_index.getData().add(new XYChart.Data<>(formattedDateTime, hourly.getUv_index()));
                }
            }

            lineChart.getData().clear();
            lineChart.getData().add(temperature_180m);
            lineChart.getData().add(relative_humidity_2m);
            lineChart.getData().add(uv_index);
        }

    }

    @FXML
    private void setTopOfApp(Weather weather) {
        currentTemp.setText(weather.getTemperature() + "°C");
        apparentTemp.setText(weather.getApparentTemperature() + "°C");

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d. MMMM yyyy");
        LocalDateTime dateTime = LocalDateTime.parse(weather.getCurrentTime());
        String formattedTime = dateTime.format(formatter1);
        String formattedDate = dateTime.format(formatter2);
        currentTime.setText(formattedTime + " o'clock");
        currentDate.setText(formattedDate);
    }

    @FXML
    protected void searchCity(ActionEvent event) {
        String cityName = cityInputField.getText().trim();
        if (!cityName.isEmpty()) {
            try {
                cities.clear();
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
        cityInputField.clear();
    }
}
