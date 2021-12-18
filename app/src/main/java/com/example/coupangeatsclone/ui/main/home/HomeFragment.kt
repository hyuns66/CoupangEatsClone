package com.example.coupangeatsclone.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adPagerAdapter = MainAdVpAdapter(this)
        binding.homeMainAdVp.adapter = adPagerAdapter

        val categoryRvAdapter = MainCategoryRvAdapter()
        val categoryItemDecoration = MainCategoryRvItemDecoration()
        categoryItemDecoration.setSize(requireContext())

        binding.homeMainCategoryRv.apply {
            adapter = categoryRvAdapter
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(categoryItemDecoration)
        }

        val popularRvAdapter = PopularRvAdapter()
        val popularItemDecoration = PopularRvItemDecoration()
        popularItemDecoration.setSize(requireContext())
        binding.homePopularRv.apply {
            adapter = popularRvAdapter
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(popularItemDecoration)
        }

        val choiceRvAdapter = ChoiceRvAdapter()
        binding.homeChoiceRv.apply{
            adapter = choiceRvAdapter
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        return binding.root
    }
}