package com.vladlen.exmapleproject

import android.app.Application
import com.vladlen.data.di.components.DaggerDataComponent
import com.vladlen.data.di.components.DataComponent
import com.vladlen.exmapleproject.di.components.ApplicationComponent
import com.vladlen.exmapleproject.di.components.DaggerApplicationComponent

class ExampleApp : Application() {

    lateinit var appComponent: ApplicationComponent

    private val dataComponent: DataComponent by lazy {
        DaggerDataComponent.factory().create(baseContext)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }

    private fun createAppComponent(): ApplicationComponent =
        DaggerApplicationComponent.factory()
            .create(this, dataComponent)
}