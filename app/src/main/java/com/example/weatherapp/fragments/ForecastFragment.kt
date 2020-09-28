package com.example.weatherapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.WeatherService
import com.example.weatherapp.adapter.ForecastAdapter
import com.example.weatherapp.common.Common
import com.example.weatherapp.model.ForecastData
import kotlinx.android.synthetic.main.fragment_forecast.*
import kotlinx.android.synthetic.main.fragment_forecast.view.*
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ForecastFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForecastFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mServiceSource: WeatherService
    lateinit var adapter: ForecastAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val  view: View  = inflater.inflate(R.layout.fragment_forecast, container, false)
        mServiceSource= Common.weatherService
        layoutManager= LinearLayoutManager(activity)
        view.rvEight.layoutManager=layoutManager
        // Inflate the layout for this fragment

        weatherForecast()
      return  view
    }
    private fun weatherForecast() {

        mServiceSource.getWeatherforecast(Common.SELECTED_CITY,Common.API_KEY,"metric").enqueue(object : retrofit2.Callback<ForecastData> {
            override fun onFailure(call: Call<ForecastData>, t: Throwable) {

                Log.d("Debug", t.toString())
                Toast.makeText(activity,"Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ForecastData>,
                response: Response<ForecastData>
            ) {
                adapter = context?.let { ForecastAdapter(it,response!!.body()!!) }!!
                adapter.notifyDataSetChanged()
                rvEight.adapter=adapter
            }

        })
    }

    override fun onResume() {
        weatherForecast()
        super.onResume()
    }

}