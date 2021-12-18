package com.example.coupangeatsclone.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coupangeatsclone.data.entities.User
import com.example.coupangeatsclone.data.remote.auth.Auth
import com.example.coupangeatsclone.data.remote.auth.AuthService
import com.example.coupangeatsclone.data.remote.auth.UserInfo
import com.example.coupangeatsclone.databinding.ActivityLoginBinding
import com.example.coupangeatsclone.ui.main.MainActivity
import com.example.coupangeatsclone.utils.saveJwt
import com.example.coupangeatsclone.utils.saveName
import com.example.coupangeatsclone.utils.savePhoneNumber
import okhttp3.internal.format

class LoginActivity : AppCompatActivity(), LogInView {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginTv.setOnClickListener {
            val loginService = AuthService()
            loginService.setLogInView(this)
            loginService.logIn(getUser())
        }
    }

    fun getUser() : User{
        val email = binding.loginEmailEt.text.toString()
        val password = binding.loginPasswordEt.text.toString()

        return User(email, password)
    }

    override fun onPostLogInSuccess(response: UserInfo) {

        saveJwt(response.jwt)
        savePhoneNumber(response.phoneNumber)
        saveName(response.name)

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

        Toast.makeText(this, String.format("{0}님 쿠팡 계정으로 로그인 했습니다.", response.name), Toast.LENGTH_SHORT).show()
    }

    override fun onPostLogInLoading() {

    }

    override fun onPostLogInFailure(code: Int, message: String) {

    }
}