package com.maxataliyev_01.task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.maxataliyev_01.task_1.Adapter.PlayerAdapter
import com.maxataliyev_01.task_1.databinding.ActivityMainBinding
import com.maxataliyev_01.task_1.mvvm.PlayerViewModel

class MainActivity : AppCompatActivity() {
    private  val playerMvvm:PlayerViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPlayers.adapter=PlayerAdapter().apply {
            playerMvvm.playersLiveData.observe(this@MainActivity, Observer {
                this.playersList=it
            })
        }
        playerMvvm.message.observe(this,Observer{
            binding.message.text=it
        })

    }


}