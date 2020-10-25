package com.vladlen.exmapleproject.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladlen.exmapleproject.di.ViewModelFactory
import com.vladlen.exmapleproject.scenes.bookfavoritlist.BookFavoriteListViewModel
import com.vladlen.exmapleproject.scenes.booklist.BookListFragment
import com.vladlen.exmapleproject.scenes.booklist.BookListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookFavoriteListViewModel::class)
    abstract fun bindRegisterViewModel(bookFavoriteListViewModel: BookFavoriteListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel::class)
    abstract fun bindBookListViewModel(bookListViewModel: BookListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}

@MustBeDocumented
@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
