package com.vladlen.exmapleproject.di.modules

import android.app.Application
import android.content.Context
import com.vladlen.exmapleproject.di.PerApplication
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule {

    @Provides
    @PerApplication
    internal fun provideContext(application: Application): Context = application.baseContext

}
