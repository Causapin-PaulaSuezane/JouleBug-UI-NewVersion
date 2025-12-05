package com.example.mobcom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaderboardAdapter(
    private val leaderboardList: List<LeaderboardUser>
) : RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRank: TextView = itemView.findViewById(R.id.tvRank)
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvLevel: TextView = itemView.findViewById(R.id.tvLevel)
        val tvXP: TextView = itemView.findViewById(R.id.tvXP)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard, parent, false)
        return LeaderboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val user = leaderboardList[position]

        holder.tvRank.text = "#${user.rank}"
        holder.tvUserName.text = user.name
        holder.tvLevel.text = "Level ${user.level}"
        holder.tvXP.text = "${user.xp} XP"
    }

    override fun getItemCount(): Int = leaderboardList.size
}