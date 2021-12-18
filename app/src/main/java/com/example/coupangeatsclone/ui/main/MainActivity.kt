package com.example.coupangeatsclone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.coupangeatsclone.R
import com.example.coupangeatsclone.databinding.ActivityMainBinding
import com.example.coupangeatsclone.ui.login.LoginBottomDialog
import com.example.coupangeatsclone.ui.main.history.HistoryFragment
import com.example.coupangeatsclone.ui.main.home.HomeFragment
import com.example.coupangeatsclone.ui.main.like.LikeFragment
import com.example.coupangeatsclone.ui.main.myInfo.MyInfoFragment
import com.example.coupangeatsclone.ui.main.search.SearchFragment
import com.example.coupangeatsclone.utils.getJwt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        supportFragmentManager.popBackStack("homeFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, HomeFragment())
                .commitAllowingStateLoss()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.popBackStack("homeFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, HomeFragment())
                            .addToBackStack("homeFragment")
                            .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    supportFragmentManager.popBackStack("searchFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, SearchFragment())
                            .addToBackStack("searchFragment")
                            .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.likeFragment -> {
                    supportFragmentManager.popBackStack("likeFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, LikeFragment())
                            .addToBackStack("likeFragment")
                            .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.historyFragment -> {
                    loginCheck("historyFragment")
                    return@setOnItemSelectedListener true
                }

                R.id.myInfoFragment -> {
                    loginCheck("myInfoFragment")
                    return@setOnItemSelectedListener true
                }

            }
            false
        }

    }

    fun loginCheck(case : String){
        val jwt = getJwt(this)
        if (jwt == ""){
            val loginSheet = LoginBottomDialog()
            loginSheet.show(supportFragmentManager, loginSheet.tag)
        } else {
            when (case){
                "historyFragment" -> {
                    supportFragmentManager.popBackStack("historyFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, HistoryFragment())
                            .addToBackStack("historyFragment")
                            .commitAllowingStateLoss()
                }
                "myInfoFragment" -> {
                    supportFragmentManager.popBackStack("myInfoFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, MyInfoFragment())
                            .addToBackStack("myInfoFragment")
                            .commitAllowingStateLoss()
                }
            }
        }
    }
}