package com.vladlen.data.di.components

import android.content.Context
import com.vladlen.data.di.modules.NetModule
import com.vladlen.data.di.modules.PersistenceModule
import com.vladlen.data.di.modules.RepositoryModule
import com.vladlen.data.net.api.GoogleBooksApi
import com.vladlen.domain.repository.BookRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetModule::class), (PersistenceModule::class), (RepositoryModule::class)])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    fun provideBooksApi(): GoogleBooksApi
    fun provideBookRepository(): BookRepository
}