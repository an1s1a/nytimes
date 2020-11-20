package com.example.nytimes.di

import com.example.nytimes.NYTApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent : AndroidInjector<NYTApplication> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<NYTApplication>
}