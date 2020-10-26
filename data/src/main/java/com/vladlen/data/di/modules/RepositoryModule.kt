package com.vladlen.data.di.modules

import com.vladlen.data.di.providers.NetworkChecker
import com.vladlen.data.mapper.BookMapper
import com.vladlen.data.net.api.GoogleBooksApi
import com.vladlen.data.persistence.dao.BookDao
import com.vladlen.data.persistence.repository.BookDataRepository
import com.vladlen.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideBookDataRepository(
        googleBooksApi: GoogleBooksApi,
        bookMapper: BookMapper,
        bookDao: BookDao,
        networkChecker: NetworkChecker
    ): BookRepository =
        BookDataRepository(googleBooksApi, bookDao, bookMapper, networkChecker)

}
