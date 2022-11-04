package com.maxataliyev_01.task_1.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api:PlayersApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlayersApi::class.java)
    }
}