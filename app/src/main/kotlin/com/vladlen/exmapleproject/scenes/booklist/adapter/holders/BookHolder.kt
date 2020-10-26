package com.vladlen.exmapleproject.scenes.booklist.adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladlen.domain.model.Book
import com.vladlen.exmapleproject.scenes.view.OnClickItem
import kotlinx.android.synthetic.main.item_book_search.view.*

class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun initView(book: Book, onClickItem: OnClickItem<Book>?, onClickFavorite: OnClickItem<Book>?) {

        itemView.txt_book_title.text = book.title
        itemView.txt_book_link.text = book.link
        Glide.with(itemView).load(book.imgLink).into(itemView.img_cover_search)

    }
}