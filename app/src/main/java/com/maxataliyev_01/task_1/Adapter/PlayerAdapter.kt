package com.maxataliyev_01.task_1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxataliyev_01.task_1.Model.Players
import com.maxataliyev_01.task_1.databinding.RowItemsBinding
import com.maxataliyev_01.task_1.pojo.User

class PlayerAdapter():RecyclerView.Adapter<PlayerAdapter.PlayersViewHolder>() {
    var playersList= emptyList<User>()
    set(value){
        field=value
        notifyDataSetChanged()
    }

    inner class PlayersViewHolder(var binding: RowItemsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        return PlayersViewHolder(
            RowItemsBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        //Glide.with(holder.itemView).load(playersList[position].photo).into(holder.binding.imgPlayer)
        holder.binding.PName.text=playersList[position].name
       // holder.binding.PAge.text=playersList[position].age.toString()
        //holder.binding.PNumber.text=playersList[position].number.toString()
        holder.binding.PPosition.text=playersList[position].email
    }

    override fun getItemCount(): Int {
        return playersList.size
    }
}