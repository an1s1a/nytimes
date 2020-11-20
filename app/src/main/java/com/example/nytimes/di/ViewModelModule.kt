package com.example.nytimes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimes.annotations.ViewModelKey
import com.example.nytimes.ui.MainViewModel
import com.example.nytimes.ui.favorite.FavoriteViewModel
import com.example.nytimes.ui.homelist.HomeListViewModel
import com.example.nytimes.ui.main.PageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(PageViewModel::class)
    abstract fun providePageViewModel(pageViewModel: PageViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(HomeListViewModel::class)
    abstract fun provideHomeListViewModel(homeListViewModel: HomeListViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun provideFavoriteViewModel(favoriteViewModel: FavoriteViewModel): ViewModel
}