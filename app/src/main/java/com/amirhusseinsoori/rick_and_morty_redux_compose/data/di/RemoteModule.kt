package com.amirhusseinsoori.rick_and_morty_redux_compose.data.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {


    @Singleton
    @Provides
    fun apolloClient(): ApolloClient =
        ApolloClient.builder().serverUrl("https://rickandmortyapi.com/graphql").build()

}