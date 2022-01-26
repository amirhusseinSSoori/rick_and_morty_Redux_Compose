package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.repository.CharactersRepositoryImp
import com.amirhusseinsoori.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideRepositoryCharacters(charactersRepositoryImp: CharactersRepositoryImp): CharactersRepository
}