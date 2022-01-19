package com.amirhusseinsoori.rick_and_morty_redux_compose.data.di

import com.amirhusseinsoori.rick_and_morty_redux_compose.data.datasource.remote.ShowCategorySourceImp
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.datasource.ShowCategorySource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SourceModule {
 @Binds
 fun provideSourceCategoryRemote(showCategorySourceImp: ShowCategorySourceImp):ShowCategorySource
}