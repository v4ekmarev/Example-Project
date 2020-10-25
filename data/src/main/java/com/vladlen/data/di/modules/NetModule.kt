package com.vladlen.data.di.modules

import android.content.Context
import com.google.gson.Gson
import com.vladlen.data.di.providers.NetworkChecker
import com.vladlen.data.net.OkHttpClientFactory
import com.vladlen.data.net.RetrofitFactory
import com.vladlen.data.net.api.GoogleBooksApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    internal fun provideNetworkChecker(context: Context): NetworkChecker = NetworkChecker(context)

    @Provides
    @Singleton
    internal fun provideOkHttpClientFactory(): OkHttpClientFactory = OkHttpClientFactory()

    @Provides
    @Singleton
    internal fun provideRetrofit(
        context: Context,
        gson: Gson,
        okHttpClientFactory: OkHttpClientFactory
    ): Retrofit =
        RetrofitFactory.getRetrofit(context, gson, okHttpClientFactory)

    @Singleton
    @Provides
    internal fun provideApiClient(retrofit: Retrofit): GoogleBooksApi =
        retrofit.create(GoogleBooksApi::class.java)
}