package com.senalkaya.oyunproje

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*


class GameAdapter (var items:ArrayList<Games>,var clickListener: OnGameItemClickListener):RecyclerView.Adapter<GameViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        lateinit var gameViewHolder:GameViewHolder
        gameViewHolder=GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent,false))
        return gameViewHolder
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
       /*holder.gameName?.text = items.get(position).name
        holder.gameDescription?.text=items.get(position).descriptor
        holder.gameLogo.setImageResource(items.get(position).logo)*/
        holder.initialize(items.get(position),clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class GameViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var gameName=itemView.gamename
    var gameDescription=itemView.gamedescription
    var gameLogo=itemView.gamelogo

    fun initialize(item:Games,action:OnGameItemClickListener){
        gameName.text = item.name
        gameDescription.text = item.descriptor
        gameLogo.setImageResource(item.logo)

        itemView.setOnClickListener {
            action.onItemClick(item,adapterPosition)
        }

    }

}

interface OnGameItemClickListener{
    fun onItemClick(item:Games,position: Int)
}