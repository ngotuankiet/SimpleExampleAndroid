package com.example.simpleexampleandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import mva2.adapter.ItemBinder
import mva2.adapter.ItemViewHolder

class UserAdapter : ItemBinder<User, UserAdapter.UserViewHolder>(){

    inner class UserViewHolder(itemView: View?) : ItemViewHolder<User>(itemView){
        private val textView = itemView?.findViewById<TextView>(R.id.textView)
        private val cardView = itemView?.findViewById<CardView>(R.id.cardView)

        fun bind(user: User){
            textView?.text = user.name
        }

    }

    override fun bindViewHolder(holder: UserViewHolder?, item: User?) {
        if (item != null) {
            holder?.bind(item)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): UserViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_user,parent, false)
        return UserViewHolder(view)
    }

    override fun canBindData(item: Any?): Boolean {
        return item is User
    }
}

class HeaderAdapter :ItemBinder<String, HeaderAdapter.HeaderViewHolder>() {

    inner class HeaderViewHolder(itemView: View?) : ItemViewHolder<String>(itemView){
        private val textView = itemView?.findViewById<TextView>(R.id.textViewHeader)

        fun bind(string: String){
            textView?.text = string
            Log.d("check","------------")
            itemView.setOnClickListener { toggleItemExpansion() }
        }
    }

    override fun bindViewHolder(holder: HeaderViewHolder?, item: String?) {
        if (item != null) {
            holder?.bind(item)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): HeaderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_header,parent,false)
        return HeaderViewHolder(view)
    }

    override fun canBindData(item: Any?): Boolean {
        return item is String
    }
}