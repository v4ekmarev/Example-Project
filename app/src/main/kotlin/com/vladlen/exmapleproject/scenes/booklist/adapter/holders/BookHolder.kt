package com.vladlen.exmapleproject.scenes.booklist.adapter.holders

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladlen.domain.model.Book
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.scenes.view.OnClickItem
import kotlinx.android.synthetic.main.item_book_search.view.*

class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun initView(book: Book, onClickItem: OnClickItem<Book>?, onClickFavorite: OnClickItem<Book>?) =
        with(itemView) {
            setOnClickListener {
                onClickItem?.click(this, book)
            }
            txt_book_title.text = book.title
            txt_book_link.text = book.link
            Glide.with(this).load(book.imgLink).into(itemView.img_cover_search)

            updateIsLiked(book, img_is_favorite)
            img_is_favorite.setOnClickListener {
                book.isFavorite = !book.isFavorite
                onClickFavorite?.click(this, book)
                updateIsLiked(book, img_is_favorite)
            }
        }

    private fun updateIsLiked(book: Book, view: ImageView) {
        view.setImageDrawable(
            ContextCompat.getDrawable(
                itemView.context,
                if (book.isFavorite) R.drawable.heart_full else R.drawable.heart_empty
            )
        )
    }
}