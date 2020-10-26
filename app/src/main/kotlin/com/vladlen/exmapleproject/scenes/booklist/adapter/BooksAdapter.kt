package com.vladlen.exmapleproject.scenes.booklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vladlen.domain.model.Book
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.scenes.booklist.adapter.holders.BookHolder
import com.vladlen.exmapleproject.scenes.view.DiffUtilGeneric
import com.vladlen.exmapleproject.scenes.view.OnClickItem

/**
 * Created by vladlen on 23.11.16.
 */
class BooksAdapter : RecyclerView.Adapter<BookHolder>() {

    private var onClickItem: OnClickItem<Book>? = null
    private var onClickFavorite: OnClickItem<Book>? = null

    private var items = mutableListOf<Book>()

    fun setOnItemClickListener(onClickItem: OnClickItem<Book>) {
        this.onClickItem = onClickItem
    }

    fun setOnLikedClickListener(onClickItem: OnClickItem<Book>) {
        this.onClickFavorite = onClickItem
    }

    fun update(newList: MutableList<Book>) {
        val diffUtilCallback = DiffUtilGeneric(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book_search, parent, false)
        return BookHolder(view)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.initView(
            items[position],
            onClickItem = onClickItem,
            onClickFavorite = onClickFavorite
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}