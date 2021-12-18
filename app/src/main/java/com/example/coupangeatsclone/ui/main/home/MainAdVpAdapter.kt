package com.example.coupangeatsclone.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.coupangeatsclone.R

class MainAdVpAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return MainAdVpFragment(R.drawable.popular_restaurant)
    }
}
