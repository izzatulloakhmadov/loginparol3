package com.example.loginparol3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
        fun getRetrofit():Retrofit{
            return Retrofit.Builder().baseUrl("https://ilkbotim.ga/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }
}