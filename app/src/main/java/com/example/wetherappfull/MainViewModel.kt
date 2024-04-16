package com.example.wetherappfull

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wetherappfull.adapter.WeatherModel
//С помощью этого класса обновляю данные(вью на экране) когда они будут готовы, не надо следить за циклом жизни фрагмента
class MainViewModel:ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}