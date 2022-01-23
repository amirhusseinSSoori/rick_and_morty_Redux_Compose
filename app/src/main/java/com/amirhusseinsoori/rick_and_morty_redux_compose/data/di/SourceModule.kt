package com.amirhusseinsoori.rick_and_morty_redux_compose.data.di

import com.amirhusseinsoori.domain.datasource.ShowCategorySource
import com.amirhusseinsoori.rick_and_morty_redux_compose.data.datasource.remote.ShowCategorySourceImp

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SourceModule {
 @Binds
 fun provideSourceCategoryRemote(showCategorySourceImp: ShowCategorySourceImp): ShowCategorySource
}