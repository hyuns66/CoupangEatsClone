package com.example.coupangeatsclone.ui.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.coupangeatsclone.data.entities.User
import com.example.coupangeatsclone.data.remote.auth.Auth
import com.example.coupangeatsclone.data.remote.auth.AuthService
import com.example.coupangeatsclone.databinding.ActivitySignUpBinding
import com.example.coupangeatsclone.ui.login.SignUpView
import com.example.coupangeatsclone.utils.saveJwt
import java.util.regex.Pattern
import kotlin.math.sign

class SignUpActivity : AppCompatActivity(), SignUpView {
    lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이메일 입력창
        binding.signUpEmailEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                val email = binding.signUpEmailEt.text.toString()
                val pattern = android.util.Patterns.EMAIL_ADDRESS
                if(pattern.matcher(email).matches()){
                    binding.signUpEmailWarningTv.visibility = View.GONE
                } else {
                    binding.signUpEmailWarningTv.visibility = View.VISIBLE
                }
            }

        })

        // 비밀번호 입력창
        binding.signUpPasswordEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.signUpPasswordWarning1Tv.visibility = View.VISIBLE
                binding.signUpPasswordWarning2Tv.visibility = View.VISIBLE
                binding.signUpPasswordWarning3Tv.visibility = View.VISIBLE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val password = binding.signUpPasswordEt.text.toString()
                val email = binding.signUpEmailEt.text.toString()
                fun isPasswordFormat(password: String): Boolean {
                    return password.matches("^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#\$%^&*])(?=.*[0-9!@#\$%^&*]).{8,20}\$".toRegex())
                }

                fun checkPwd(pwd : String) : Boolean {
                    val match = Pattern.compile("(\\w)\\1\\1").matcher(pwd)

                    return match.find()
                }

                if(isPasswordFormat(password)){
                    binding.signUpPasswordWarning1Tv.setTextColor(Color.parseColor("#008000"))
                } else {
                    binding.signUpPasswordWarning1Tv.setTextColor(Color.parseColor("#FF0000"))
                }

                if(checkPwd(password)){
                    binding.signUpPasswordWarning2Tv.setTextColor(Color.parseColor("#008000"))
                } else {
                    binding.signUpPasswordWarning2Tv.setTextColor(Color.parseColor("#008000"))
                }

                if(password != email){
                    binding.signUpPasswordWarning3Tv.setTextColor(Color.parseColor("#008000"))
                } else {
                    binding.signUpPasswordWarning3Tv.setTextColor(Color.parseColor("#FF0000"))
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.signUpBtnTv.setOnClickListener {
            val signUpService = AuthService()
            signUpService.setSignUpView(this)
            signUpService.signUp(getUser())
        }

    }

    fun getUser() : User{
        val email = binding.signUpEmailEt.text.toString()
        val password = binding.signUpPasswordEt.text.toString()
        val name = binding.signUpNameEt.text.toString()
        val phoneNumber = binding.signUpPhoneEt.text.toString()

        return User(email, password, name, phoneNumber)
    }

    override fun onPostSignUpSuccess(response: Auth) {
        Toast.makeText(this, "회원가입이 완료되었습니다. 쿠팡 아이디(이메일)로 로그인 해주세요.", Toast.LENGTH_SHORT).show()
        onBackPressed()
    }

    override fun onPostSignUpLoading() {

    }

    override fun onPostSignUpFailure(code: Int, message: String) {
        Toast.makeText(this, code.toString(), Toast.LENGTH_SHORT).show()
    }
}