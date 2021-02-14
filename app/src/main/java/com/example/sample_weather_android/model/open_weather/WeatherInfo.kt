package com.example.sample_weather_android.model.open_weather

data class WeatherInfo(
    val name: String,
    val main: MainWeather,
    val weather: List<Weather>
)
