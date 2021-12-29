package com.example.coupangeatsclone.ui.main.home

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Looper.getMainLooper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsclone.data.remote.restaurant.Category
import com.example.coupangeatsclone.data.remote.restaurant.CategoryService
import com.example.coupangeatsclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CategoryView{
    lateinit var binding : FragmentHomeBinding
    private var pagerHandler = Handler(Looper.getMainLooper())
    lateinit var swiper : AdBannerAutoSwiper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("homeOnAttach()", "homeOnAttach()!!!")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("homeOnCreate()", "homeOnCreate()!!!")

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setView()
        initSwiper()

        val adPagerAdapter = MainAdVpAdapter(this)
        binding.homeMainAdVp.adapter = adPagerAdapter

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

    override fun onPause() {
        super.onPause()
        swiper.interrupt()
    }

    fun setView(){
        setCategory()
    }

    fun setCategory(){
        val categoryService = CategoryService()
        categoryService.setCategoryView(this)
        categoryService.getCategory()
    }

    fun initSwiper(){
        val adVpAdapter = MainAdVpAdapter(this)
        val itemCount = adVpAdapter.itemCount
        swiper = AdBannerAutoSwiper(itemCount)
        swiper.start()
    }

    inner class AdBannerAutoSwiper(private val itemCount: Int) : Thread(){
        override fun run() {
            try {
                while (true){
                    sleep(6000)
                    pagerHandler.post{
                        var position = binding.homeMainAdVp.currentItem
                        if(position == itemCount-1){
                            position = 0
                            binding.homeMainAdVp.currentItem = position
                        } else {
                            position++
                            binding.homeMainAdVp.currentItem = position
                        }
                    }
                }
            } catch (e: InterruptedException){
                Log.d("interrupt", "쓰레드 종료")
            }
        }
    }

    override fun onGetCategorySuccess(categoryList: ArrayList<Category>) {
        val categoryRvAdapter = MainCategoryRvAdapter(requireContext(), categoryList)
        val categoryItemDecoration = MainCategoryRvItemDecoration()
        categoryItemDecoration.setSize(requireContext())

        binding.homeMainCategoryRv.apply {
            adapter = categoryRvAdapter
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(categoryItemDecoration)
        }
    }

    override fun onGetCategoryLoading() {

    }

    override fun onGetCategoryFailure(code: Int, message: String) {

    }
}