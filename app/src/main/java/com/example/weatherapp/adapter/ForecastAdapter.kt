package com.example.weatherapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.viewholder.ForecastViewholder
import kotlinx.android.synthetic.main.fragment_today.*

class ForecastAdapter(private val context: Context, private val forecastResponse: ForecastData) :
    RecyclerView.Adapter<ForecastViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewholder {

        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.forecast_inflate, parent, false)
        return ForecastViewholder(itemView)
    }


    override fun getItemCount(): Int {
        return forecastResponse.weather.size
    }

    override fun onBindViewHolder(holder: ForecastViewholder, position: Int) {

        holder.weather_title.text = forecastResponse.weather[position].weather.get(0).description
        holder.textview_max.text = forecastResponse.weather[position].main.tempMax.toString()
        holder.textview_min.text = forecastResponse.weather[position].main.feelsLike.toString()
        holder.textview_day.text = forecastResponse.weather[position].date
        when(holder.weather_title.text) {
            "mist" -> holder.imageView.setImageResource(R.drawable.mist)
            "clear Sky" -> holder.imageView.setImageResource(R.drawable.sun)
            "thunderstorm" -> holder.imageView.setImageResource(R.drawable.thunderstorm)
            "scattered clouds" -> holder.imageView.setImageResource(R.drawable.scatteredthunderstorms)
            "few clouds" -> holder.imageView.setImageResource(R.drawable.cloudy)
            "drizzle" -> holder.imageView.setImageResource(R.drawable.drizzle)
            else -> holder.imageView.setImageResource(R.drawable.clear)

        }
        //holder.source_timestamp.text = newsResponse.articles!![position]!!.publishedAt

        // Picasso.get().load(newsResponse.articles[position]!!.urlToImage).into(holder.source_image);

//        holder.setItemClicklistener(object : ItemClickListener {
//
//
//        })

    }
}


