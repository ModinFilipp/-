package com.example.wetherappfull.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
//адаптер для переключения фрагментов при переключении(скролле) tabLayout
class VpAdapter(fa:FragmentActivity, private val list:List<Fragment>): FragmentStateAdapter(fa) {
    //возвращает кол-во элементов(позиций) в списке
    override fun getItemCount(): Int {
       return list.size
    }
// открывает фрагмент по позиции
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}