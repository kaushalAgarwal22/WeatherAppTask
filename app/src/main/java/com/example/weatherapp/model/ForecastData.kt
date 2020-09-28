package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

data class ForecastData(

      @SerializedName("list")
      val weather: List<WeatherData>

  )
