package com.example.nytimes

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.example.nytimes.di.DaggerAppComponent

class NYTApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}