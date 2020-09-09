package com.example.simpleexampleandroid

import android.content.Context
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleexampleandroid.databinding.ItemUserBinding
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter constructor(
    val context: Context,
    val userAdapterK: UserAdapter
) : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffUtil) {

    // if checkedPosition = -1, there is no default selection
    // if checkedPosition = 0, 1st item is selected by default
    private var checkedPosition = -1

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val textView = itemView.findViewById<TextView>(R.id.textViewName)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        fun set(user: User) {
            textView.text = user.name

            //single item selection
            if (checkedPosition != adapterPosition) imageView.visibility = View.GONE
            else if(checkedPosition == adapterPosition) imageView.visibility = View.VISIBLE

            itemView.setOnClickListener {
                imageView.visibility = View.VISIBLE
                notifyItemChanged(checkedPosition)
                checkedPosition = adapterPosition

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.set(getItem(position))
    }

    object UserDiffUtil : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun submitList(list: List<User>?) {
        super.submitList(list)
    }

}