package com.vladlen.exmapleproject.di.components

import android.app.Application
import com.vladlen.data.di.components.DataComponent
import com.vladlen.data.di.modules.UseCaseModule
import com.vladlen.exmapleproject.di.PerApplication
import com.vladlen.exmapleproject.di.modules.ApplicationModule
import dagger.BindsInstance
import dagger.Component


@PerApplication
@Component(
    dependencies = [(DataComponent::class)],
    modules = [(ApplicationModule::class), (UseCaseModule::class)]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application, dataComponent: DataComponent): ApplicationComponent
    }

    fun activityComponent(): ActivityComponent.Factory

}
