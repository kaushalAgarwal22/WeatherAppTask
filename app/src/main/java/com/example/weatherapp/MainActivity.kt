package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.adapter.ViewPagerAdapter
import com.example.weatherapp.fragments.ForecastFragment
import com.example.weatherapp.fragments.TodayFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViewPager()
    }



    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment( "Today ",TodayFragment())
        adapter.addFragment( "5 days", ForecastFragment())

        viewpager.adapter = adapter
        tabs?.setupWithViewPager(viewpager)

    }
}