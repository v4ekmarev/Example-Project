package com.vladlen.exmapleproject.di.components

import android.app.Activity
import com.vladlen.exmapleproject.di.PerActivity
import com.vladlen.exmapleproject.di.modules.ActivityModule
import com.vladlen.exmapleproject.di.modules.ViewModelModule
import com.vladlen.exmapleproject.scenes.bookfavoritlist.BookFavoriteListFragment
import com.vladlen.exmapleproject.scenes.booklist.BookListFragment
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [(ActivityModule::class), (ViewModelModule::class)])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): ActivityComponent
    }

    //region Inject
    fun inject(fragment: BookListFragment)

    fun inject(fragment: BookFavoriteListFragment)
}
