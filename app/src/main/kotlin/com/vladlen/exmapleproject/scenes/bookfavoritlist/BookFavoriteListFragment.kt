package com.vladlen.exmapleproject.scenes.bookfavoritlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladlen.domain.model.Book
import com.vladlen.exmapleproject.R
import com.vladlen.exmapleproject.extensions.build
import com.vladlen.exmapleproject.scenes.base.BaseFragment
import com.vladlen.exmapleproject.scenes.booklist.adapter.BooksAdapter
import com.vladlen.exmapleproject.scenes.view.OnClickItem
import com.vladlen.exmapleproject.scenes.view.ResultState
import kotlinx.android.synthetic.main.framgnet_book_favorite_list.*

class BookFavoriteListFragment : BaseFragment(R.layout.framgnet_book_favorite_list) {

    private val favoriteBookViewModel: BookFavoriteListViewModel by viewModels {
        viewModelFactory
    }

    private val booksAdapter: BooksAdapter by lazy { BooksAdapter() }

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

        rcl_favorite_book?.apply {
            adapter = booksAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        booksAdapter.setOnFavoriteClickListener(object : OnClickItem<Book> {
            override fun click(view: View, item: Book) {
                favoriteBookViewModel.updateFavoriteBook(item)
            }
        })

        favoriteBookViewModel.getFavoriteBookListLiveData().observe(viewLifecycleOwner, {
            when (it) {
                is ResultState.Loading -> {
                    pb_load_favorite_book.visibility = View.VISIBLE
                }
                is ResultState.Success -> {
                    pb_load_favorite_book.visibility = View.INVISIBLE
                    booksAdapter.update(it.data as MutableList<Book>)
                    if (it.data.isNullOrEmpty()) {
                        btn_empty_list.visibility = View.VISIBLE
                    }
                }
                is ResultState.Error -> {
                    pb_load_favorite_book.visibility = View.INVISIBLE
                }
            }
        })

        btn_empty_list.setOnClickListener {
            favoriteBookViewModel.router().routeToBookList()
        }

        favoriteBookViewModel.fetchFavoriteBookList()
    }
}