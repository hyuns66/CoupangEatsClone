package com.example.coupangeatsclone.ui.main.myInfo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coupangeatsclone.databinding.FragmentMyInfoBinding
import com.example.coupangeatsclone.utils.getName
import com.example.coupangeatsclone.utils.getPhoneNumber

class MyInfoFragment : Fragment() {
    lateinit var binding : FragmentMyInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyInfoBinding.inflate(inflater, container, false)

        binding.myInfoSettingTv.setOnClickListener{
            val intent = Intent(requireContext(), SettingActivity::class.java)
            startActivity(intent)
        }

        binding.myInfoNameTv.text = getName()
        binding.myInfoPhoneTv.text = getPhoneNumber()

        return binding.root
    }
}