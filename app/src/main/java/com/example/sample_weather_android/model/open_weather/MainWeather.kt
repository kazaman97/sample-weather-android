package com.example.sample_weather_android.model.open_weather

import com.squareup.moshi.Json

data class MainWeather(
    val temp: String,
    @field:Json(name = "temp_min") val tempMin: String,
    @field:Json(name = "temp_max") val tempMax: String
)
