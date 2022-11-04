package com.maxataliyev_01.task_1.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxataliyev_01.task_1.Model.Players
import com.maxataliyev_01.task_1.pojo.User
import com.maxataliyev_01.task_1.retrofit.userService
import kotlinx.coroutines.launch


class PlayerViewModel:ViewModel() {
    val playersLiveData=MutableLiveData<List<User>>()
    val message=MutableLiveData<String?>()

    init {
        viewModelScope.launch {
            try {
                message.postValue("Loading...")
                val players= userService.getAllPlayers()
                playersLiveData.postValue(players)
                message.postValue(null)
            }
            catch (ex:java.lang.Exception){
                message.postValue("Server encountered error.")
            }
        }
    }



   /* fun getAllPlayers(){
        RetrofitInstance.api.getAllPlayers().enqueue(object : Callback<PlayersList>{
            override fun onResponse(call: Call<PlayersList>, response: Response<PlayersList>) {
                if (response.body()!=null){
                    val players:Players=response.body()!!.players[0]
                    playersLiveData.value=players
                }
            }

            override fun onFailure(call: Call<PlayersList>, t: Throwable) {
                Log.d("MainActivity",t.message.toString())
            }

        })
    }*/


}