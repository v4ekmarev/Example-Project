package com.vladlen.exmapleproject

import android.os.Bundle
import android.os.PersistableBundle
import com.vladlen.exmapleproject.scenes.base.BaseActivity
import com.vladlen.exmapleproject.scenes.booklist.BookListFragment

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        supportFragmentManager.beginTransaction().replace(R.id.container, BookListFragment.newInstance()).commit()
    }
}