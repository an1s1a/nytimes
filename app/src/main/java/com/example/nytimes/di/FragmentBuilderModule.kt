package com.example.nytimes.di

import com.example.nytimes.annotations.FragmentScope
import com.example.nytimes.ui.favorite.FavoriteFragment
import com.example.nytimes.ui.homelist.HomeListFragment
import com.example.nytimes.ui.main.PlaceholderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun placeHolderFragment(): PlaceholderFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun homeListFragment(): HomeListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun favoriteFragment(): FavoriteFragment
}