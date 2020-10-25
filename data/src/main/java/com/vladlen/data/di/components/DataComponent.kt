package com.vladlen.data.di.components

import android.content.Context
import com.vladlen.data.di.modules.NetModule
import com.vladlen.data.di.modules.PersistenceModule
import com.vladlen.data.net.api.GoogleBooksApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetModule::class), (PersistenceModule::class)])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    fun provideBooksApi(): GoogleBooksApi
}