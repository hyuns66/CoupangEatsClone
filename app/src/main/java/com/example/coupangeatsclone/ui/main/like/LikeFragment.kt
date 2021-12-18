package com.example.coupangeatsclone.ui.main.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coupangeatsclone.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {
    lateinit var binding : FragmentLikeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLikeBinding.inflate(inflater, container, false)

        return binding.root
    }
}