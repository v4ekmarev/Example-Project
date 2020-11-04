package com.vladlen.exmapleproject.scenes.view

import androidx.recyclerview.widget.DiffUtil

class DiffUtilGeneric<T>(
    private var oldList: MutableList<T>,
    private var newList: MutableList<T>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldList[oldItem] == newList[newItem]
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return false
    }
}