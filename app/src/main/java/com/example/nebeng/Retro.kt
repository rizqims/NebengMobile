package com.example.nebeng

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun  getRetroClient():Retrofit{
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.10:8000/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
