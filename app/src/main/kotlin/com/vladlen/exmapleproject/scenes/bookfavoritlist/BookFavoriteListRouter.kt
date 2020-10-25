package com.vladlen.exmapleproject.scenes.bookfavoritlist

import androidx.appcompat.app.AppCompatActivity
import com.vladlen.exmapleproject.extensions.showUrlInBrowser
import javax.inject.Inject

class BookFavoriteListRouter
@Inject internal constructor(private val activity: AppCompatActivity) {
    fun routeToLink(url: String) {
        activity.showUrlInBrowser(url)
    }
}