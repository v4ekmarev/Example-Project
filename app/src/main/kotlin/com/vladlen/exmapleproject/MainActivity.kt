package com.vladlen.exmapleproject

import android.os.Bundle
import android.os.PersistableBundle
import com.vladlen.exmapleproject.scenes.base.BaseActivity
import com.vladlen.exmapleproject.scenes.bookfavoritlist.BookFavoriteListFragment
import com.vladlen.exmapleproject.scenes.booklist.BookListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().add(R.id.container, BookListFragment.newInstance()).commit()

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    supportFragmentManager.beginTransaction().add(R.id.container, BookFavoriteListFragment.newInstance()).addToBackStack(null).commit()
                    true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, BookListFragment.newInstance()).commit()
                    true
                }
                else -> false
            }
        }
    }
}