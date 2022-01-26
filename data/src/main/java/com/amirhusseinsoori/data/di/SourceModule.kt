package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.datasource.remote.ShowCharactersSourceImp
import com.amirhusseinsoori.domain.datasource.ShowCharactersSource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SourceModule {
 @Binds
 fun provideSourceCharactersRemote(showCategorySourceImp: ShowCharactersSourceImp): ShowCharactersSource
}