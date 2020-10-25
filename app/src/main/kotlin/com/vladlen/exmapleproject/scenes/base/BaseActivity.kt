package com.vladlen.exmapleproject.scenes.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vladlen.exmapleproject.ExampleApp
import com.vladlen.exmapleproject.di.components.ActivityComponent
import com.vladlen.exmapleproject.di.components.ApplicationComponent
import javax.inject.Inject

open class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private val applicationComponent: ApplicationComponent by lazy {
        (application as ExampleApp).appComponent
    }

    val activityComponent: ActivityComponent by lazy {
        applicationComponent.activityComponent().create(this)
    }

}