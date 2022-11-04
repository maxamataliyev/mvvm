package com.maxataliyev_01.task_1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxataliyev_01.task_1.databinding.RowItemsBinding
import com.maxataliyev_01.task_1.pojo.User

class UserAdapter : RecyclerView.Adapter<UserVH>() {
    var users = emptyList<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = RowItemsBinding.inflate(LayoutInflater.from(parent.context))
        return UserVH(binding)
    }
    override fun getItemCount(): Int {
        return users.size
    }
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]
        holder.bind(user)
    }
}
class UserVH(private val binding: RowItemsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.PName.text = user.name
        binding.PPosition.text = user.email
        //binding.userInitial.text = user.name.substring(0, 1)
    }
}