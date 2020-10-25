package com.vladlen.exmapleproject.scenes.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.vladlen.exmapleproject.ExampleApp
import com.vladlen.exmapleproject.di.components.ActivityComponent
import com.vladlen.exmapleproject.di.components.ApplicationComponent
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected val appComponent: ApplicationComponent by lazy { (requireActivity().application as ExampleApp).appComponent }

    protected val activityComponent: ActivityComponent by lazy { (activity as BaseActivity).activityComponent }

    protected val baseFragmentManager: FragmentManager by lazy { requireActivity().supportFragmentManager }

    abstract fun activityComponentInject()

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponentInject()
    }
}