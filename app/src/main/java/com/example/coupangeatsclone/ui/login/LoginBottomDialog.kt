package com.example.coupangeatsclone.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coupangeatsclone.databinding.FragmentLoginBottomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LoginBottomDialog : BottomSheetDialogFragment() {
    lateinit var binding : FragmentLoginBottomDialogBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBottomDialogBinding.inflate(inflater, container, false)

        return binding.root
    }
}