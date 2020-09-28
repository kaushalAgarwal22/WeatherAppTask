package com.example.weatherapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.weatherapp.R
import com.example.weatherapp.RetrofitInstance
import com.example.weatherapp.WeatherService
import com.example.weatherapp.common.Common
//import com.example.weatherapp.fragments.spinner
import com.example.weatherapp.model.WeatherData
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.android.synthetic.main.fragment_today.view.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class TodayFragment : Fragment() {

    lateinit var retServce: WeatherService

    var city = String
    lateinit var  spinner: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_today, container, false)
        retServce = Common.weatherService

        val sdf = SimpleDateFormat("dd MMM, hh:mm")
        val currentDate = sdf.format(Date())
        Log.i("Info",currentDate)

        view.textViewTime.text = currentDate


        spinner = view.findViewById(R.id.citySpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity!!,
            R.array.city,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        loadWeatherSource()




          spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
              override fun onNothingSelected(p0: AdapterView<*>?) {
              }

              override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                  //Toast.makeText(activity, parent?.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
                  Common.SELECTED_CITY =  parent?.getItemAtPosition(position).toString()
                  loadWeatherSource()
              }


          }


        return view
    }



    private fun loadWeatherSource() {

        retServce.getWeather(spinner.selectedItem.toString(), Common.API_KEY,"metric")
            .enqueue(object : retrofit2.Callback<WeatherData> {
                override fun onFailure(call: Call<WeatherData>, t: Throwable) {

                    Log.d("Debug", t.toString())
                    Toast.makeText(activity, "Failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<WeatherData>,
                    response: Response<WeatherData>
                )
                {
                    val weatherResponse = response.body()
                    textViewTemp.text = weatherResponse?.weather?.get(0)!!.description

                    //   textView.text = weatherResponse.sys.sunrise.toString()
                    textViewFeels.text = "Feels like " +weatherResponse.main.feelsLike.toString()+ " C"
                    tvTemp.text = weatherResponse.main.tempMax.toString()

                    when( textViewTemp.text) {
                        "mist" -> imageView2.setImageResource(R.drawable.mist)
                        "clear Sky" -> imageView2.setImageResource(R.drawable.sun)
                        "thunderstorm" -> imageView2.setImageResource(R.drawable.thunderstorm)
                        "scattered clouds" -> imageView2.setImageResource(R.drawable.scatteredthunderstorms)
                        "few clouds" -> imageView2.setImageResource(R.drawable.cloudy)
                        "drizzle" -> imageView2.setImageResource(R.drawable.drizzle)
                        else -> imageView2.setImageResource(R.drawable.clear)
                    }

                }

            })
    }


}