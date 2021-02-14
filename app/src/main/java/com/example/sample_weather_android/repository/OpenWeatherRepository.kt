package com.example.sample_weather_android.repository

import android.content.Context
import android.util.Log
import com.example.sample_weather_android.R
import com.example.sample_weather_android.data.api.OpenWeatherService
import com.example.sample_weather_android.model.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

internal class OpenWeatherRepository @Inject constructor(
    private val service: OpenWeatherService,
    @ApplicationContext private val context: Context
) {
    companion object {
        private val TAG = OpenWeatherRepository::class.java.simpleName
    }

    fun getWeather(city: String): Flow<Result> = flow {
        try {
            with(
                service.getWeather(
                    city = city,
                    appId = context.getString(R.string.open_weather_app_id)
                ).execute()
            ) {
                if (isSuccessful) {
                    body()?.let { emit(Result.Success(it)) }
                } else {
                    errorBody()?.let { emit(Result.Failed(it.string())) }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "getWeather error", e)
        } catch (e: IOException) {
            Log.e(TAG, "getWeather error", e)
        }
    }.flowOn(Dispatchers.IO)
}
