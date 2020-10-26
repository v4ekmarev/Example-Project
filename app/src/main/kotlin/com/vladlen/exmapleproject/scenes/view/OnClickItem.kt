package com.vladlen.exmapleproject.scenes.view

import android.view.View

interface OnClickItem<T> {
    fun click(view: View, item: T)
}