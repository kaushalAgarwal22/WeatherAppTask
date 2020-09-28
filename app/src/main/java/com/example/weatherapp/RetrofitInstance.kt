package com.example.weatherapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        val BaseUrl = "api.openweathermap.org/data/2.5/"

        val interceptor = HttpLoggingInterceptor().apply {

            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {

            this.addInterceptor(interceptor)
        }.build()
        //    this.ad

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BaseUrl).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
        }
    }
}