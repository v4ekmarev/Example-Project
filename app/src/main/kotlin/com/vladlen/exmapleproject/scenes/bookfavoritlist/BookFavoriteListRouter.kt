package com.vladlen.exmapleproject.scenes.bookfavoritlist

import androidx.appcompat.app.AppCompatActivity
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.scenes.booklist.BookListFragment
import javax.inject.Inject

class BookFavoriteListRouter
@Inject internal constructor(private val activity: AppCompatActivity) {
    fun routeToBookList() {
        activity.supportFragmentManager.beginTransaction().replace(R.id.container, BookListFragment.newInstance()).commit()
    }
}