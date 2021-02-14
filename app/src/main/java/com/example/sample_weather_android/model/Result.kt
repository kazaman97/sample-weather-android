package com.example.sample_weather_android.model

import com.example.sample_weather_android.model.open_weather.WeatherInfo

sealed class Result {
    data class Success(val weatherInfo: WeatherInfo) : Result()
    data class Failed(val error: String) : Result()
}
