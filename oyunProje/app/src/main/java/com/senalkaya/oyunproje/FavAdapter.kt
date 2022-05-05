package com.senalkaya.oyunproje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_itemfav.view.*

class FavAdapter(var items:ArrayList<FavGames>) : RecyclerView.Adapter<FavViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        lateinit var favViewHolder: FavViewHolder
        favViewHolder=FavViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_itemfav,parent,false))
        return favViewHolder
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
       holder.favName?.text=items.get(position).name
       holder.favDescript?.text=items.get(position).descriptor
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class FavViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var favName=itemView.titleFav
    var favDescript=itemView.descFav
}

