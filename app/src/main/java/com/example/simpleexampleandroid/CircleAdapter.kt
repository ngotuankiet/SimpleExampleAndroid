package com.example.simpleexampleandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CircleAdapter(private val arrayList: ArrayList<Int>) : RecyclerView.Adapter<CircleAdapter.CircleViewHolder>() {

    inner class CircleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val ivCircle: ImageView = itemView.findViewById(R.id.iv_circle)


        //set color
        fun getColorCircle(position: Int){

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircleViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_circle, parent, false)
        return CircleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CircleViewHolder, position: Int) {
        holder.getColorCircle(position)
    }
}