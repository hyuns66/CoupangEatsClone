package com.example.coupangeatsclone.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coupangeatsclone.databinding.FragmentHomeMainAdVpBinding

class MainAdVpFragment(val imgRes : Int) : Fragment() {
    lateinit var binding : FragmentHomeMainAdVpBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeMainAdVpBinding.inflate(inflater, container, false)

        binding.homeMainAdIv.setImageResource(imgRes)

        return binding.root
    }
}