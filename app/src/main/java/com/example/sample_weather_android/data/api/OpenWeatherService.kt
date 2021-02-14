package com.example.sample_weather_android.data.api

import com.example.sample_weather_android.model.open_weather.WeatherInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface OpenWeatherService {
    @GET("/data/2.5/weather?lang=ja&units=metric")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") appId: String
    ): Call<WeatherInfo>
}
