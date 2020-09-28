package com.example.weatherapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.forecast_inflate.view.*

class ForecastViewholder (itemView : View): RecyclerView.ViewHolder(itemView),View.OnClickListener {

   // private  lateinit var itemClickListener: ItemClickListener

    var weather_title= itemView.textViewWeather
    var textview_max =itemView.textViewMax
    var textview_min =itemView.textViewMin
    var textview_day =itemView.textViewDay
    var imageView=   itemView.imageViewCloud

    // var source_image = itemView.ivNews

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
      //  TODO("Not yet implemented")
    }


//    fun setItemClicklistener(itemClickListener: ItemClickListener)
//    {
//        this.itemClickListener= itemClickListener
//    }
//
//    override fun onClick(v: View?) {
//
//        itemClickListener.onClick(v!!,adapterPosition)
//    }
}