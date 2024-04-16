# Weather Application <a name="top"></a>
The documentation covers several of the project's components that I developed for the **SRC** technical evaluation.

## Table of Contents
1. [About the app](#app)
	1. [Description](#description)
	2. [Features](#features)
	3. [Installation](#installation)
	4. [Usage](#usage)
	5. [Dependencies](#dependencies)
2. [About development](#dev)
   	1. [Sample data](#sampledata)
   		1. [Geocoding](#geocoding)
   	 	2. [Forecast](#forecast)
3. [Improvements](#improvements)

# About the app <a name="app"></a>
## Description <a name="description"></a>
This **JavaFX** application provides weather information for a given city. It allows users to search for weather by city name, view current weather conditions, and see daily and hourly forecasts and history.
I chose **IntelliJ Idea** as my IDE. It's got a powerful toolkit for personalization, setting run and build parameters, debugging code and has a wide variety of useful keyboard shortcuts.

## Features <a name="features"></a>
- Search for weather by city name
- Display current weather conditions
- Show daily, hourly forecasts and history
- Customize units (temperature, wind speed, etc.)
- Saving a searched city

## Installation <a name="installation"></a>
1. Clone this repository.
```
$ git clone https://github.com/Polloux/SRChallenge.git
```
2. Ensure you have Java 8 or higher installed.
3. Build the project using Maven
```
mvn clean install
```
5. Run the application

## Usage <a name="usage"></a>
1. Launch the application.
2. Enter the name of the city you want to search for in the input field.
3. Click the search button.
4. View the weather information displayed on the screen.
5. Use the toggle buttons to switch between daily, hourly forecasts and history.

## Dependencies <a name="dependencies"></a>
- JavaFX
- Gson (for JSON parsing)
- Apache Commons IO (for file operations)
- Maven (for dependency management)

# About development <a name="dev"></a>
The reason I chose **JavaFX** over Swing for my GUI was because JavaFX provides a more modern and greater user interface toolkit compared to Swing. JavaFX has better support for 2D and 3D graphics, animations, and styling through CSS. JavaFX has a more intuitive and flexible scene graph-based architecture and is actively maintained by Oracle, which means compatibility with newer Java versions and ongoing improvements. 

I impleted **MVC** in my app, with an additional package for handling API calls. I've implemented my own classes for handling API calls. 

<br>

`Geocoding` gets `City` (including `latitude` and `longitude`) from a searched city name string.

The example Geocoding API call to 

```
https://geocoding-api.open-meteo.com/v1/search?name=Maribor&count=10&language=en&format=json
```
will return mainly longitude, latitude and country from each found entry.

<br>

`Forecast` gets `Weather` (including daily and hourly forecast and history) from `longitude` and `latitude` values. 

The example Forecast API call to 
```
https://api.open-meteo.com/v1/forecast?latitude=46.5547&longitude=15.6467&current=temperature_2m,apparent_temperature&hourly=temperature_2m,relative_humidity_2m,temperature_180m,uv_index&daily=temperature_2m_max,temperature_2m_min,uv_index_max&timezone=Europe%2FBerlin&past_days=7&past_hours=24&forecast_hours=24
``` 
will return daily data for 14 days (7 past and 7 future daily data) about maximum and minimum temperatures and maximum uv indexes. Detailed hourly data will give temperature, uv index, relative humidity information as well as current temperature and apparent temparature.

## Sample data <a name="sampledata"></a>
### Geocoding <a name="geocoding"></a>
``` json
{
  "results": [
    {
      "id": 3195506,
      "name": "Maribor",
      "latitude": 46.55472,
      "longitude": 15.64667,
      "elevation": 266,
      "feature_code": "PPLA",
      "country_code": "SI",
      "admin1_id": 3195505,
      "timezone": "Europe/Ljubljana",
      "population": 95171,
      "country_id": 3190538,
      "country": "Slovenia",
      "admin1": "Maribor"
    },
    {
      "id": 3195504,
      "name": "Mariborski Otok",
      "latitude": 46.56667,
      "longitude": 15.61667,
      "elevation": 259,
      "feature_code": "ISL",
      "country_code": "SI",
      "admin1_id": 3195505,
      "timezone": "Europe/Ljubljana",
      "country_id": 3190538,
      "country": "Slovenia",
      "admin1": "Maribor"
    },
    {
      "id": 6299644,
      "name": "Maribor Edvard Rusjan Airport",
      "latitude": 46.47986,
      "longitude": 15.68613,
      "elevation": 267,
      "feature_code": "AIRP",
      "country_code": "SI",
      "admin1_id": 3344920,
      "timezone": "Europe/Ljubljana",
      "country_id": 3190538,
      "country": "Slovenia",
      "admin1": "Občina Hoče-Slivnica"
    }
  ],
  "generationtime_ms": 0.39696693
}
```

### Forecast<a name="forecast"></a>
``` json
{
  "latitude": 46.56,
  "longitude": 15.639999,
  "generationtime_ms": 3.5550594329834,
  "utc_offset_seconds": 7200,
  "timezone": "Europe/Berlin",
  "timezone_abbreviation": "CEST",
  "elevation": 262,
  "current_units": {
    "time": "iso8601",
    "interval": "seconds",
    "temperature_2m": "°C",
    "apparent_temperature": "°C"
  },
  "current": {
    "time": "2024-04-16T11:00",
    "interval": 900,
    "temperature_2m": 7.5,
    "apparent_temperature": 4.5
  },
  "hourly_units": {
    "time": "iso8601",
    "temperature_2m": "°C",
    "relative_humidity_2m": "%",
    "temperature_180m": "°C",
    "uv_index": ""
  },
  "hourly": {
    "time": [
      "2024-04-15T11:00",
      "2024-04-15T12:00",
      "2024-04-15T13:00",
      "2024-04-15T14:00",
      "2024-04-15T15:00",
      "2024-04-15T16:00",
      "2024-04-15T17:00",
      "2024-04-15T18:00",
      "2024-04-15T19:00",
      "2024-04-15T20:00",
      "2024-04-15T21:00",
      "2024-04-15T22:00",
      "2024-04-15T23:00",
      "2024-04-16T00:00",
      "2024-04-16T01:00",
      "2024-04-16T02:00",
      "2024-04-16T03:00",
      "2024-04-16T04:00",
      "2024-04-16T05:00",
      "2024-04-16T06:00",
      "2024-04-16T07:00",
      "2024-04-16T08:00",
      "2024-04-16T09:00",
      "2024-04-16T10:00",
      "2024-04-16T11:00",
      "2024-04-16T12:00",
      "2024-04-16T13:00",
      "2024-04-16T14:00",
      "2024-04-16T15:00",
      "2024-04-16T16:00",
      "2024-04-16T17:00",
      "2024-04-16T18:00",
      "2024-04-16T19:00",
      "2024-04-16T20:00",
      "2024-04-16T21:00",
      "2024-04-16T22:00",
      "2024-04-16T23:00",
      "2024-04-17T00:00",
      "2024-04-17T01:00",
      "2024-04-17T02:00",
      "2024-04-17T03:00",
      "2024-04-17T04:00",
      "2024-04-17T05:00",
      "2024-04-17T06:00",
      "2024-04-17T07:00",
      "2024-04-17T08:00",
      "2024-04-17T09:00",
      "2024-04-17T10:00"
    ],
    "temperature_2m": [24.6, 26.1, 27.6, 27.6, 28, 27.1, 25.9, 23.9, 22.5, 21.8, 21, 20.1, 20.3, 19.4, 15.7, 14.3, 13.2, 13.1, 13, 13.1, 13.3, 12.7, 11.8, 8.3, 7.5, 7.7, 7, 6.1, 5.4, 4.3, 3.7, 4.6, 5, 4, 4.3, 5.4, 5.6, 5.3, 4.9, 4.8, 4.7, 4.5, 4.5, 2.8, 3, 5.5, 7.8, 10.4],
    "relative_humidity_2m": [39, 36, 34, 30, 27, 30, 29, 33, 37, 35, 36, 41, 42, 44, 62, 72, 79, 80, 80, 80, 81, 86, 84, 81, 84, 79, 78, 80, 81, 83, 85, 82, 82, 87, 85, 79, 76, 78, 81, 82, 83, 81, 80, 96, 95, 80, 67, 62],
    "temperature_180m": [21.7, 22.9, 24.3, 24.2, 24.8, 24.3, 23.6, 22, 21.1, 20.7, 20.3, 20.2, 19.9, 19.1, 17.6, 12.5, 11.7, 11.8, 12.2, 12, 11.5, 10.7, 9.7, 6, 5.1, 5.3, 4.6, 3.6, 2.9, 1.6, 1.1, 2.3, 3.1, 2.4, 4.1, 4.8, 4.9, 4.6, 4.4, 4.4, 4.6, 4.8, 5, 4.5, 4.6, 5.1, 6.1, 7.7],
    "uv_index": [4.4, 5.55, 5.85, 5.55, 4.8, 3.8, 2.65, 1.4, 0.55, 0.05, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1, 0.2, 0.05, 0.1, 0.1, 0.2, 0.35, 0.8, 0.6, 0.7, 0.55, 0.45, 0.15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.15, 0.85, 1.95, 2.95]
  },
  "daily_units": {
    "time": "iso8601",
    "temperature_2m_max": "°C",
    "temperature_2m_min": "°C",
    "uv_index_max": ""
  },
  "daily": {
    "time": [
      "2024-04-09",
      "2024-04-10",
      "2024-04-11",
      "2024-04-12",
      "2024-04-13",
      "2024-04-14",
      "2024-04-15",
      "2024-04-16",
      "2024-04-17",
      "2024-04-18",
      "2024-04-19",
      "2024-04-20",
      "2024-04-21",
      "2024-04-22"
    ],
    "temperature_2m_max": [28.6, 18, 20.2, 22.3, 25.3, 31.3, 28, 19.4, 14.1, 11.9, 13.2, 13.5, 11.6, 7],
    "temperature_2m_min": [12.5, 12.1, 7.9, 9, 10.5, 11.4, 12, 3.7, 2.8, 5.3, 2.9, 4.5, 4.1, 4.8],
    "uv_index_max": [5.65, 4.25, 5.05, 5.75, 5.95, 6.1, 5.85, 0.8, 4.95, 5.15, 5.75, 4.75, 5.15, 4.8]
  }
}
```      

# Improvements <a name="improvements"></a>
- Cleaning up code
- Fixing bugs of glitching graph ticks on resize
- Separating history from future forecasts
- Highlighting todays date and measurements
- Changing formatting in saved city preferences
- Improving the look of the GUI
- Adding graph data on hover popup with big font value

<br/>

This assignment was a lot of fun :)

<div align="right">
    <b><a class="top-link hide" href="#top">↑ Back to the top</a></b>
</div>

<b>Author:</b> <i>Nea Nikolić</i>
