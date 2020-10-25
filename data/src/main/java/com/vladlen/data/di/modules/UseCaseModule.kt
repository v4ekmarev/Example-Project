package com.vladlen.data.di.modules

import com.vladlen.domain.usecases.base.UseCaseScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    internal fun providePostScheduler() = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    internal fun provideUseCaseScheduler(postScheduler: Scheduler) =
        UseCaseScheduler(Schedulers.io(), postScheduler)

}
