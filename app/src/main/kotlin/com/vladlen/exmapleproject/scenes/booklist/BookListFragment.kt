package com.vladlen.exmapleproject.scenes.booklist

import android.os.Bundle
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.extensions.build
import com.vladlen.exmapleproject.scenes.base.BaseFragment
import com.vladlen.exmapleproject.scenes.bookfavoritlist.BookFavoriteListFragment

class BookListFragment : BaseFragment(R.layout.framgnet_book_list) {

    companion object {
        fun newInstance(): BookFavoriteListFragment =
            BookFavoriteListFragment().build {

            }
    }

    override fun activityComponentInject() {
        activityComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}