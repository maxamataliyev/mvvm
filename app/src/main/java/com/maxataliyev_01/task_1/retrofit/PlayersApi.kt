package com.maxataliyev_01.task_1.retrofit

import com.maxataliyev_01.task_1.Model.Players
import com.maxataliyev_01.task_1.pojo.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val userService: PlayersApi =Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(PlayersApi::class.java  )
interface PlayersApi {
    @GET("users")
    suspend fun getAllPlayers(): List<User>
}