package com.example.loginparol3


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String
)