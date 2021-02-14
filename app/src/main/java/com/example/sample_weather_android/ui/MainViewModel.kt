package com.example.sample_weather_android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.sample_weather_android.model.Result
import com.example.sample_weather_android.repository.OpenWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val openWeatherRepository: OpenWeatherRepository
) : ViewModel() {
    fun getWeather(city: String): LiveData<Result> =
        openWeatherRepository.getWeather(city).asLiveData()
}
