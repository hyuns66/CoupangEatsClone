package com.example.coupangeatsclone.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coupangeatsclone.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(){
    lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}