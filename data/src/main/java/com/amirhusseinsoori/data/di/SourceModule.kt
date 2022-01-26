package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.datasource.ShowCategorySourceImp
import com.amirhusseinsoori.domain.datasource.ShowCategorySource

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