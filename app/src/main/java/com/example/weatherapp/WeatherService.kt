package com.example.weatherapp

import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.model.WeatherData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {



    @GET("weather")
    fun getWeather(@Query("q") city:String,@Query("appid")apikey:String,@Query("units")units:String): Call<WeatherData>


    @GET("forecast")
    fun getWeatherforecast(@Query("q") city:String,@Query("appid")apikey:String,@Query("units")units:String): Call<ForecastData>
}