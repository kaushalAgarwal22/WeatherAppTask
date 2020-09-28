package com.example.weatherapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {

    @Insert
    fun  insertWeatherData(weather: Weather)

    @Query("SELECT * FROM weather_data_table ")
    fun  getWeatherData():List<Weather>

}