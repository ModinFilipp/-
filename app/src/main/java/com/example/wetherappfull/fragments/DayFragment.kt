package com.example.wetherappfull.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wetherappfull.MainViewModel
import com.example.wetherappfull.R
import com.example.wetherappfull.adapter.WeatherAdapter
import com.example.wetherappfull.adapter.WeatherModel
import com.example.wetherappfull.databinding.FragmentDayBinding


class DayFragment : Fragment(),WeatherAdapter.Listener {
    private lateinit var binding: FragmentDayBinding
    private lateinit var adapter:WeatherAdapter
    private val model:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        //выдаем список с элементами на день
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
    //подключаю rcView(DayFragment) к WeatherAdapter
    private fun init() = with(binding){
        adapter = WeatherAdapter(this@DayFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = DayFragment()
    }

    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value = item
    }
}