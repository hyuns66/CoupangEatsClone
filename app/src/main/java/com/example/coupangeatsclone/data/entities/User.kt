package com.example.coupangeatsclone.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class User(
        val email : String,
        val password : String,
        val name : String,
        val phoneNumber : String
)