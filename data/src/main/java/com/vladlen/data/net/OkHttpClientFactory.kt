package com.vladlen.data.net

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import com.vladlen.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

open class OkHttpClientFactory {

    open fun createOkHttpClient(context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                updateTimeout()
                if (BuildConfig.DEBUG) {
                    enableDebugTools(context)
                }
            }
            .build()

    private fun OkHttpClient.Builder.enableDebugTools(context: Context) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        addInterceptor(logging)
        addInterceptor(ChuckInterceptor(context))
    }

    private fun OkHttpClient.Builder.updateTimeout(read: Long = 60, write: Long = 60) {
        readTimeout(read, TimeUnit.SECONDS)
        writeTimeout(write, TimeUnit.SECONDS)
    }
}