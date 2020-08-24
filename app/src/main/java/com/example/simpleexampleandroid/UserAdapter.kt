package com.example.simpleexampleandroid

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.zip.Inflater

class UserAdapter constructor(
    context: Context
) : ListAdapter<User, UserAdapter.UserViewHolder>(
    AsyncDifferConfig.Builder<User>(NoteDiffCallBack())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView : TextView = itemView.findViewById(R.id.textView)

        fun onBind(user: User){
            textView.text = user.name + user.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = inflater.inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun submitList(list: MutableList<User>?) {
        super.submitList(ArrayList<User>(list ?: listOf()))
    }
}