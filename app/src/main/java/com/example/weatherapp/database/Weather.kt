package com.example.weatherapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather_data_table")
data class Weather(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    var id: Int,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String,

    @SerializedName("temp_max")
    @ColumnInfo(name = "temp_max")
    var maxTemp: String,

    @SerializedName("feels_like")
    @ColumnInfo(name = "feels_like")
    var feels: String,

    @SerializedName("dt_txt")
    @ColumnInfo(name = "dt_txt")
    var date: String



)