package com.senalkaya.oyunproje.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.senalkaya.oyunproje.R

class MyViewPagerAdapter(var context: Context):RecyclerView.Adapter<MyViewPagerAdapter.MyViewHolder>() {

    var color_icon_matrix = arrayOf<IntArray>(
        intArrayOf(R.color.white,R.drawable.p11),
        intArrayOf(R.color.white,R.drawable.p2),
        intArrayOf(R.color.white,R.drawable.p3),
        intArrayOf(R.color.white,R.drawable.p4)
    )


    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        lateinit var img_view:ImageView
        lateinit var container:RelativeLayout
        init{
            img_view=itemView.findViewById(R.id.img_view) as ImageView
            container=itemView.findViewById(R.id.container) as RelativeLayout

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img_view.setImageResource(color_icon_matrix[position][1]) // 1 icon sutun
        holder.container.setBackgroundResource(color_icon_matrix[position][0])  // 0 renk sutun

    }

    override fun getItemCount(): Int {
        return color_icon_matrix.size
    }
}