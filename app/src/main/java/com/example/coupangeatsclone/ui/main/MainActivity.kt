package com.example.coupangeatsclone.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.coupangeatsclone.ApplicationClass
import com.example.coupangeatsclone.R
import com.example.coupangeatsclone.databinding.ActivityMainBinding
import com.example.coupangeatsclone.ui.login.LoginBottomDialog
import com.example.coupangeatsclone.ui.main.history.HistoryFragment
import com.example.coupangeatsclone.ui.main.home.HomeFragment
import com.example.coupangeatsclone.ui.main.like.LikeActivity
import com.example.coupangeatsclone.ui.main.myInfo.MyInfoFragment
import com.example.coupangeatsclone.ui.main.search.SearchFragment
import com.example.coupangeatsclone.utils.getJwt
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val homeFragment = HomeFragment()
    val searchFragment = SearchFragment()
    val historyFragment = HistoryFragment()
    val myInfoFragment = MyInfoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .add(R.id.main_frame, homeFragment, "home")
                .commitAllowingStateLoss()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    if(homeFragment.isAdded){
                        supportFragmentManager.beginTransaction()
                            .show(homeFragment)
                            .hide(searchFragment)
                            .hide(historyFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame, homeFragment, "home")
                            .hide(searchFragment)
                            .hide(historyFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    }
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    if(searchFragment.isAdded){
                        supportFragmentManager.beginTransaction()
                            .hide(homeFragment)
                            .show(searchFragment)
                            .hide(historyFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame, searchFragment, "search")
                            .hide(homeFragment)
                            .hide(historyFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    }
                    return@setOnItemSelectedListener true
                }

                R.id.likeFragment -> {
                    val intent = Intent(this, LikeActivity::class.java)
                    startActivity(intent)
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
        val jwt = getJwt()
        if (jwt == null){
            val loginSheet = LoginBottomDialog()
            loginSheet.show(supportFragmentManager, loginSheet.tag)
        } else {
            when (case){
                "historyFragment" -> {
                    if(historyFragment.isAdded){
                        supportFragmentManager.beginTransaction()
                            .hide(homeFragment)
                            .hide(searchFragment)
                            .show(historyFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame, historyFragment)
                            .hide(homeFragment)
                            .hide(searchFragment)
                            .hide(myInfoFragment)
                            .commitAllowingStateLoss()
                    }
                }
                "myInfoFragment" -> {
                    if(myInfoFragment.isAdded){
                        supportFragmentManager.beginTransaction()
                            .hide(homeFragment)
                            .hide(searchFragment)
                            .hide(historyFragment)
                            .show(myInfoFragment)
                            .commitAllowingStateLoss()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frame, myInfoFragment)
                            .hide(homeFragment)
                            .hide(searchFragment)
                            .hide(historyFragment)
                            .commitAllowingStateLoss()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if(homeFragment.isVisible){
            super.onBackPressed()
        } else {
            if(homeFragment.isAdded){
                supportFragmentManager.beginTransaction()
                    .show(homeFragment)
                    .hide(searchFragment)
                    .hide(historyFragment)
                    .hide(myInfoFragment)
                    .commitAllowingStateLoss()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_frame, homeFragment)
                    .commitAllowingStateLoss()
            }
            binding.bottomNavigationView.menu.findItem(R.id.homeFragment).isChecked = true
        }
    }
}