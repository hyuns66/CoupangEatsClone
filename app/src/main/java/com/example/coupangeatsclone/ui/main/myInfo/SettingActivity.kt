package com.example.coupangeatsclone.ui.main.myInfo

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.coupangeatsclone.ApplicationClass
import com.example.coupangeatsclone.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeatsclone.ApplicationClass.Companion.mSharedPreferences
import com.example.coupangeatsclone.databinding.ActivitySettingBinding
import com.example.coupangeatsclone.ui.main.MainActivity

class SettingActivity : AppCompatActivity(){
    lateinit var binding : ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)

        // 로그아웃 버튼
        binding.settingLogoutTv.setOnClickListener {
            val dlg = AlertDialog.Builder(this)
            dlg.setTitle("정말로 로그아웃 하시겠습니까?")

            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1){
                        DialogInterface.BUTTON_POSITIVE -> logout()
                    }
                }
            }
            dlg.setPositiveButton("로그아웃", listener)
            dlg.setNegativeButton("취소", listener)
            dlg.show()
        }
        setContentView(binding.root)
    }

    fun logout(){
        val editor = mSharedPreferences.edit()
        editor.remove(X_ACCESS_TOKEN)
        editor.apply()

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}