package com.example.simpleexampleandroid

import androidx.recyclerview.widget.DiffUtil

class UserDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    /**
     * Kiem tra 2 object coi khac nhau ko, thuong so sanh qua key cua object do.
     * */

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    /**
     *
     * */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

}