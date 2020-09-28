package com.example.weatherapp.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.util.Log.d
import androidx.core.content.ContextCompat.getSystemService
import com.example.weatherapp.WeatherService
import java.util.logging.Logger

object  Common {

   val  BASE_URL="https://api.openweathermap.org/data/2.5/"
   val API_KEY ="249f1df3658f89b8b97ed034eb6184ed"

   var SELECTED_CITY= "Bangalore"

   val weatherService :WeatherService get() = RetrofitClient.getClient(BASE_URL).create(WeatherService::class.java)


   private fun hasNetworkAvailable(context: Context): Boolean {
      val service = Context.CONNECTIVITY_SERVICE
      val manager = context.getSystemService(service) as ConnectivityManager?
      val network = manager?.activeNetworkInfo
      Log.d("Debug", "hasNetworkAvailable: ${(network != null)}")
      return (network != null)
   }
}