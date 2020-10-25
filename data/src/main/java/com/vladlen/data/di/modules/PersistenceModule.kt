package com.vladlen.data.di.modules

import android.content.Context
import com.vladlen.data.persistence.AppDatabase
import com.vladlen.data.persistence.DatabaseFactory
import com.vladlen.data.persistence.dao.BookDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PersistenceModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        DatabaseFactory.getDatabase(context)

    @Provides
    @Singleton
    internal fun provideBookDao(appDatabase: AppDatabase): BookDao = appDatabase.bookDao()

}
