package com.vladlen.exmapleproject.scenes.booklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladlen.domain.model.Book
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.extensions.build
import com.vladlen.exmapleproject.scenes.base.BaseFragment
import com.vladlen.exmapleproject.scenes.bookfavoritlist.BookFavoriteListFragment
import com.vladlen.exmapleproject.scenes.booklist.adapter.BooksAdapter
import com.vladlen.exmapleproject.scenes.view.ResultState
import kotlinx.android.synthetic.main.framgnet_book_list.*

class BookListFragment : BaseFragment(R.layout.framgnet_book_list) {

    private val storeViewModel: BookListViewModel by viewModels {
        viewModelFactory
    }

    private val booksAdapter: BooksAdapter by lazy { BooksAdapter() }

    companion object {
        fun newInstance(): BookListFragment =
            BookListFragment().build {

            }
    }

    override fun activityComponentInject() {
        activityComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rcl_book?.apply {
            adapter = booksAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        storeViewModel.getBookListLiveData().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultState.Loading -> {
                    pb_load_book.visibility = View.VISIBLE
                }
                is ResultState.Success -> {
                    pb_load_book.visibility = View.INVISIBLE
                    booksAdapter.update(it.data as MutableList<Book>)
                }
                is ResultState.Error -> {
                    pb_load_book.visibility = View.INVISIBLE
                }
            }
        })

        storeViewModel.fetchBookList("Book")
    }

}