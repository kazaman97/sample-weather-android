package com.example.sample_weather_android.ui

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.example.sample_weather_android.R
import com.example.sample_weather_android.databinding.ActivityMainBinding
import com.example.sample_weather_android.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.bind(findViewById<ViewGroup>(android.R.id.content)[0])!!
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            search.setOnClickListener {
                viewModel.getWeather(inputCity.text.toString()).observe(this@MainActivity) {
                    if (it is Result.Success) {
                        weatherInfo = it.weatherInfo
                    } else if (it is Result.Failed) {
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
