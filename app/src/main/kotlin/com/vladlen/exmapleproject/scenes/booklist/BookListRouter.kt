package com.vladlen.exmapleproject.scenes.booklist

import androidx.appcompat.app.AppCompatActivity
import com.vladlen.exmapleproject.extensions.showUrlInBrowser
import javax.inject.Inject

class BookListRouter
@Inject internal constructor(private val activity: AppCompatActivity) {

    fun routeToLink(url: String) {
        activity.showUrlInBrowser(url)
    }
}