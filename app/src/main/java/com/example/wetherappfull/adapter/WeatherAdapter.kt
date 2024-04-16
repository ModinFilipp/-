package com.example.wetherappfull.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wetherappfull.R
import com.example.wetherappfull.databinding.ListItemBinding
import com.squareup.picasso.Picasso

//это адаптер, который заполняет list item информацией из WeatherModel и показывает во фрагменте
class WeatherAdapter(val listener: Listener?):ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {

    //класс, который хранит созданную WeatherAdapter разметку в памяти в случае если ее не видно на экране
    //То есть list_item не создается заново при проматывании вниз и обратно
    class Holder(view:View, val listener: Listener?):RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)
        var itemTemp:WeatherModel? = null
        init {
            itemView.setOnClickListener{
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun bind(item: WeatherModel)= with(binding){
            itemTemp = item
            tvDate.text = item.time
            tvConditions.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.minTemp}°С/${item.maxTemp}°С" }
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }
    //класс проверяет элементы погоды на совпадение и меняет только те, где есть разница
    class Comparator:DiffUtil.ItemCallback<WeatherModel>(){
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }
    // метод WeatherAdapter который создает разметку
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    // метод WeatherAdapter который показывает созданную разметку
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
    //интерфейс для прослушивания нажатия на элементы Days
    interface Listener{
        fun onClick(item: WeatherModel)
    }
}